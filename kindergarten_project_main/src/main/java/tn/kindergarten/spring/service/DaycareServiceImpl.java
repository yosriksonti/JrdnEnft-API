package tn.kindergarten.spring.service;

import java.util.ArrayList;
<<<<<<< Updated upstream
=======
import java.util.Comparator;
>>>>>>> Stashed changes
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
<<<<<<< Updated upstream
import java.util.TreeMap;
=======
>>>>>>> Stashed changes

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Child;
import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Parent;
<<<<<<< Updated upstream
import tn.kindergarten.spring.entities.Position;
=======
>>>>>>> Stashed changes
import tn.kindergarten.spring.entities.Post;
import tn.kindergarten.spring.entities.Favorite;
import tn.kindergarten.spring.entities.Graph;
import tn.kindergarten.spring.entities.Node;
import tn.kindergarten.spring.repository.DaycareRepository;
import tn.kindergarten.spring.repository.FavoriteRepository;
<<<<<<< Updated upstream
import tn.kindergarten.spring.repository.PostRepository;

import java.awt.geom.Point2D;
=======
>>>>>>> Stashed changes
@Service
public class DaycareServiceImpl implements IDaycareService 
{
	
	
	@Autowired
	DaycareRepository daycareRepository;
<<<<<<< Updated upstream
	@Autowired
	PostRepository postRepository;
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
	    source.setDistance((double)0);
=======
	    source.setDistance((Integer)0);
>>>>>>> Stashed changes

	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();

	    unsettledNodes.add(source);

	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
<<<<<<< Updated upstream
	        for (Entry < Node, Double> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Double edgeWeight = adjacencyPair.getValue();
=======
	        for (Entry < Node, Integer> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	    double lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        double nodeDistance = node.getDistance();
=======
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
>>>>>>> Stashed changes
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	private static void calculateMinimumDistance(Node evaluationNode,
<<<<<<< Updated upstream
			Double edgeWeigh, Node sourceNode) {
		Double sourceDistance = sourceNode.getDistance();
=======
			  Integer edgeWeigh, Node sourceNode) {
			    Integer sourceDistance = sourceNode.getDistance();
>>>>>>> Stashed changes
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}
	
<<<<<<< Updated upstream
	public Map<String,String> getShortestPathsChildren(int daycareId) {
		Daycare daycare = findById(daycareId);
		Position daycarePosition = daycare.getPosition();
		List<Child> daycareChildren = getDaycareChildren(daycareId);
		Graph graph = new Graph();
		Node daycareNode = new Node("Daycare",": 'https://www.google.com/maps/search/"+daycare.getPosition().getX()+","+daycare.getPosition().getY()+"?sa=X&ved=2ahUKEwjPx4HuxsbvAhUJC-wKHQeiCzwQ8gEwAHoECAIQAQ' ");
		List<Node> nodes = new ArrayList<Node>();
		int mainCounter = 0, secondaryCounter = 0;
		for(Child child : daycareChildren) {
			Node childNode = new Node(child.getName(),": 'https://www.google.com/maps/search/"+child.getPosition().getX()+","+child.getPosition().getY()+"?sa=X&ved=2ahUKEwjPx4HuxsbvAhUJC-wKHQeiCzwQ8gEwAHoECAIQAQ' ");
			nodes.add(childNode);
		}
		int nodesSize = nodes.size();
		for(Child child : daycareChildren) {
			Node mainChildNode = nodes.get(mainCounter);
			daycareNode.addDestination(mainChildNode,Point2D.distance(daycarePosition.getX(), daycarePosition.getY(), child.getPosition().getX(), child.getPosition().getY()) );
=======
	public Map<String,Integer> getShortestPathsChildren(int daycareId) {
		List<Child> daycareChildren = getDaycareChildren(daycareId);
		Graph graph = new Graph();
		Node daycareNode = new Node("Daycare");
		List<Node> nodes = new ArrayList<Node>();
		int mainCounter = 0, secondaryCounter = 0;
		for(Child child : daycareChildren) {
			nodes.add(new Node(child.getName()));
		}
		daycareNode.addDestination(nodes.get(0), 1);
		int nodesSize = nodes.size();
		for(Child child : daycareChildren) {
			Node mainChildNode = nodes.get(mainCounter%nodesSize);
>>>>>>> Stashed changes
			for(Child child2 : daycareChildren) {
				if(child.getId() != child2.getId()) {
					System.out.println("##################");
					System.out.println("Main: "+child.getName());
					System.out.println("Secondary: "+child2.getName());
<<<<<<< Updated upstream
					System.out.println("Distance: "+Point2D.distance(child.getPosition().getX(),child.getPosition().getY(), child2.getPosition().getX(), child2.getPosition().getY()));
					Node secondaryChildNode = nodes.get(secondaryCounter);
					mainChildNode.addDestination(secondaryChildNode, Point2D.distance(child.getPosition().getX(), child.getPosition().getY(), child2.getPosition().getX(),child2.getPosition().getY()));
=======
					System.out.println("Distance: "+(mainCounter+1)*(secondaryCounter+1));
					Node secondaryChildNode = nodes.get(secondaryCounter%nodesSize);
					mainChildNode.addDestination(secondaryChildNode, (mainCounter+1)*(secondaryCounter+1));
>>>>>>> Stashed changes
				}
				secondaryCounter++;
			}
			mainCounter++;
			secondaryCounter=0;
			graph.addNode(mainChildNode);
		}
		graph.addNode(daycareNode);
		Graph pathGraph = calculateShortestPathFromSource(graph, daycareNode);
<<<<<<< Updated upstream
		Map<Node,Double> map = new HashMap<>();
		for(Node node : pathGraph.getNodes()) {
			map.put(node, node.getDistance());
		}
		LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedMap.put(x.getKey().getName(), x.getKey().getMaps()));;
		return sortedMap;
=======
		Map<String,Integer> map = new HashMap<>();
		for(Node node : pathGraph.getNodes()) {
			map.put(node.getName(), node.getDistance());
		}
		return map;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	///////////////////// POSTS /////////////////////
	public List<Post> addDaycarePost(Post post){
		Daycare daycare = daycareRepository.findById(post.getDaycare().getId()).get();
		List<Post> posts = daycare.getPosts();
		posts.add(post);
		daycare.setPosts(posts);
		daycareRepository.save(daycare);
		return posts;
	}
	
	
	
	///////////////////// POSTS /////////////////////
=======
>>>>>>> Stashed changes
	
	
	@Autowired
    FavoriteRepository favoriteRepository;
	public int affecterDaycareFavoritee(Favorite favorite) 
	{
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
	
	public Favorite getFavoriteeById(int id) 
	{
		
		return favoriteRepository.findById(id).get();

	
	}
<<<<<<< Updated upstream
=======
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
				System.out.println(post.getLikes() + " " + post.getDislikes());
				sumLikes += post.getLikes();
				sumDislikes += post.getDislikes();
			}
			
			statics.put(daycare.getDaycareName(),(sumLikes+sumDislikes) != 0 ?sumLikes/(sumLikes+sumDislikes)*100: 0);
		
		}
    	LinkedHashMap<String,Double> sortedMap = new LinkedHashMap<>();
    	statics.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()) );
    	return sortedMap;
    	
    	
    	
    	
    }
>>>>>>> Stashed changes
}
