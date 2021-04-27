package tn.kindergarten.spring.service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Child;
import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Parent;
import tn.kindergarten.spring.entities.Position;
import tn.kindergarten.spring.entities.Post;
import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.entities.Graph;
import tn.kindergarten.spring.entities.Node;
import tn.kindergarten.spring.repository.DaycareRepository;
import tn.kindergarten.spring.repository.FavoriteRepository;
@Service
public class DaycareServiceImpl implements IDaycareService 
{
	
	
	@Autowired
	DaycareRepository daycareRepository;

	@Override
	public boolean addDaycare(Daycare daycare) {
		daycareRepository.save(daycare);
		return true;
	}

	@Override
	public boolean deleteDaycare(int id) {
		daycareRepository.delete(daycareRepository.findById(id).get());
		return true;
	}

	@Override
	public boolean updateDaycare(Daycare daycare) {
		daycareRepository.save(daycare);
		return true;
	}

	@Override
	public Daycare findById(int id) {
		Daycare daycare = daycareRepository.findById(id).get(); 
		return daycare;
	}
	public Daycare findDaycareChild(int idChild) {
		List<Daycare> daycares = findAll();
		Daycare daycare = new Daycare();
		boolean found = false;
		for(Daycare dc : daycares) {
			List<Parent> parents = dc.getParents();
			for(Parent parent : parents) {
				List<Child> children = parent.getChildren();
				for(Child child : children) {
					if(child.getId() == idChild) {
						daycare = dc;
						found = true;
						break;
					}
				}
				if(found) {
					break;
				}
			}
			if(found) {
				break;
			}
		}
		return daycare;
	}

	@Override
	public List<Daycare> findAll() {
		 List<Daycare> tmp = (List<Daycare>) daycareRepository.findAll();
		 return tmp;
	}
	
	public List<Daycare> tmp(int managerId) {
		 List<Daycare> tmp = (List<Daycare>) daycareRepository.findAll();
		 List<Daycare> daycares = new ArrayList<Daycare>();
		 for(Daycare daycare : tmp ) {
			 if(daycare.getManager().getId() == managerId ) {
				 daycares.add(daycare);
			 }
		 }
		 return daycares;
	}
	
	
	/*////////////////// APIs /////////////////////*/
public List<Child> getDaycareChildren(int id){
		
		List<Daycare> daycares = findAll();
		List<Child> daycareChildren = new ArrayList<Child>();
		for(Daycare dc : daycares) {
			List<Parent> parents = dc.getParents();
			for(Parent parent : parents) {
				List<Child> children = parent.getChildren();
				for(Child child : children) {
					daycareChildren.add(child);
				}
			}
		}
		return daycareChildren;
	}
	
	
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
	    source.setDistance((double)0);

	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();

	    unsettledNodes.add(source);

	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry < Node, Double> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Double edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return graph;
	}
	
	private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
	    Node lowestDistanceNode = null;
	    double lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        double nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	private static void calculateMinimumDistance(Node evaluationNode,
			Double edgeWeigh, Node sourceNode) {
		Double sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}
	
	public List<String> getShortestPathsChildren(int daycareId) {
		Daycare daycare = findById(daycareId);
		Position daycarePosition = daycare.getPosition();
		List<Child> daycareChildren = getDaycareChildren(daycareId);
		Graph graph = new Graph();
		Node daycareNode = new Node("Daycare","https://www.google.com/maps/search/"+daycare.getPosition().getX()+","+daycare.getPosition().getY()+"?sa=X&ved=2ahUKEwjPx4HuxsbvAhUJC-wKHQeiCzwQ8gEwAHoECAIQAQ");
		List<Node> nodes = new ArrayList<Node>();
		int mainCounter = 0, secondaryCounter = 0;
		for(Child child : daycareChildren) {
			Node childNode = new Node(child.getName(),"https://www.google.com/maps/search/"+child.getPosition().getX()+","+child.getPosition().getY()+"?sa=X&ved=2ahUKEwjPx4HuxsbvAhUJC-wKHQeiCzwQ8gEwAHoECAIQAQ");
			nodes.add(childNode);
		}
		int nodesSize = nodes.size();
		for(Child child : daycareChildren) {
			Node mainChildNode = nodes.get(mainCounter);
			daycareNode.addDestination(mainChildNode,Point2D.distance(daycarePosition.getX(), daycarePosition.getY(), child.getPosition().getX(), child.getPosition().getY()) );
			for(Child child2 : daycareChildren) {
				if(child.getId() != child2.getId()) {
					System.out.println("##################");
					System.out.println("Main: "+child.getName());
					System.out.println("Secondary: "+child2.getName());
					System.out.println("Distance: "+Point2D.distance(child.getPosition().getX(),child.getPosition().getY(), child2.getPosition().getX(), child2.getPosition().getY()));
					Node secondaryChildNode = nodes.get(secondaryCounter);
					mainChildNode.addDestination(secondaryChildNode, Point2D.distance(child.getPosition().getX(), child.getPosition().getY(), child2.getPosition().getX(),child2.getPosition().getY()));
				}
				secondaryCounter++;
			}
			mainCounter++;
			secondaryCounter=0;
			graph.addNode(mainChildNode);
		}
		graph.addNode(daycareNode);
		Graph pathGraph = calculateShortestPathFromSource(graph, daycareNode);
		Map<Node,Double> map = new HashMap<>();
		for(Node node : pathGraph.getNodes()) {
			map.put(node, node.getDistance());
		}
		List<String> sortedList = new ArrayList();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedList.add(x.getKey().getMaps()));;
		return sortedList;
	}
	/* Node mainChildNode = new Node(child.getName());
			if(counter == 0 ) {
				daycareNode.addDestination(mainChildNode, 1);
			}
			for(Child child2 : daycareChildren) {
				counter++;
				System.out.println("#####COUNTER: "+counter+"#####");
				if(child.getId() != child2.getId() && counter%3 == 0) {
					System.out.println("Main: "+child.getName());
					System.out.println("Secondary: "+child2.getName());
					System.out.println("Distance: "+counter);
					Node secondaryChildNode = new Node(child2.getName());
					mainChildNode.addDestination(secondaryChildNode, counter);
				}
				
			}
			graph.addNode(mainChildNode); */

	/*////////////////// APIs /////////////////////*/

	
	
	@Autowired
    FavoriteRepository favoriteRepository;
	public int affecterDaycareFavoritee(Favorite favorite) 
	{
		System.out.println("Resp"+favorite.getDaycares().get(0).getId());
		Daycare daycare = favorite.getDaycares().get(0);
		Daycare daycareManagerEntity = daycareRepository.findById(favorite.getDaycares().get(0).getId()).get();
		Favorite favoriteManagedEntity = favoriteRepository.findById(favorite.getId()).get();

		if(favoriteManagedEntity.getDaycares()== null)
		{

			List<Daycare> daycares = new ArrayList<>();
			daycares.add(daycareManagerEntity);
			favoriteManagedEntity.setDaycares(daycares);
		}
		else
		{
			List<Daycare> daycares = favoriteManagedEntity.getDaycares();
			daycares.add(daycareManagerEntity);
			favoriteManagedEntity.setDaycares(daycares);

		}
		favoriteRepository.save(favoriteManagedEntity);
        return 1 ;
	}
	public int supprimerDaycareFavoritee(Favorite favorite) 
	{
		Daycare daycare = favorite.getDaycares().get(0);
		Daycare daycareManagerEntity = daycareRepository.findById(favorite.getDaycares().get(0).getId()).get();
		Favorite favoriteManagedEntity = favoriteRepository.findById(favorite.getId()).get();

		if(!(favoriteManagedEntity.getDaycares()== null))
		{

			List<Daycare> daycares = favoriteManagedEntity.getDaycares();
			int index = -1;
			for(Daycare dc : daycares) {
				index ++;
				if(dc.getId() == daycareManagerEntity.getId() ) {
					break;
				}
			}
			System.out.println(index);
			daycares.remove(index);
			favoriteManagedEntity.setDaycares(daycares);

		}
		favoriteRepository.save(favoriteManagedEntity);
        return 1;
	}
	
	public List<Daycare> getFavoriteeById(int id) 
	{
		List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
		int favoriteId = -1;
		for(Favorite favorite : favorites) {
			if(favorite.getVisitor().getId() == id) {
				favoriteId = favorite.getId();
				break;
			}
		}
		
		if(favoriteId != -1) {
			return favoriteRepository.findById(favoriteId).get().getDaycares();
		} else {
			return new ArrayList();
		}
	}
	public Daycare removeParent(int daycareId , int parentId) {
		Daycare daycare = findById(daycareId);
		List<Parent> parents = daycare.getParents();
		for(int i = 0;i<parents.size();i++) {
			if (parents.get(i).getId()==parentId) {
				parents.remove(i);
			}
		}
		daycare.setParents(parents);
		daycareRepository.save(daycare);
		return daycare;
		
		
		
	}
	/////////////statistic/////////////
    @Override
    public Map<String,Double> getStatic(){
    	List<Daycare> daycares = findAll();
    	Map<String,Double> statics = new HashMap<String,Double>();
		for(Daycare daycare : daycares) {
			double sumLikes = 0;
			double sumDislikes = 0;
			List<Post> daycarePosts = daycare.getPosts();
			for(Post post : daycarePosts) {
				sumLikes += post.getLikes();
				sumDislikes += post.getDislikes();
			}
			statics.put(daycare.getDaycareName(),(sumLikes+sumDislikes) != 0 ? 100*sumLikes/(sumLikes+sumDislikes) : 0);
		
		}
    	LinkedHashMap<String,Double> sortedMap = new LinkedHashMap<>();
    	statics.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()) );
    	return sortedMap;
    	
    	
    	
    	
    }
    public List<Daycare> getClosestToPosition(Position position){
    	
    	List<Daycare> daycares = findAll();
    	daycares.sort(( d1, d2) -> {
    		return (int) (Point2D.distance(d1.getPosition().getX(), d1.getPosition().getY(), position.getX(),position.getY()) - Point2D.distance(d2.getPosition().getX(), d2.getPosition().getY(), position.getX(),position.getY())) * 1000;
    	});
    	return daycares;
    }
}
