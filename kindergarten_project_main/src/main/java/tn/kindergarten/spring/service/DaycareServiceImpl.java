package tn.kindergarten.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.spring.entities.Child;
import tn.kindergarten.spring.entities.Daycare;
import tn.kindergarten.spring.entities.Parent;
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
		return daycareRepository.findById(id).get();
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
	
	/////////////////// APIs //////////////////////
	
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
	    source.setDistance((Integer)0);

	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();

	    unsettledNodes.add(source);

	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry < Node, Integer> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
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
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	private static void calculateMinimumDistance(Node evaluationNode,
			  Integer edgeWeigh, Node sourceNode) {
			    Integer sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}
	
	public Graph getShortestPathsChildren(int daycareId) {
		List<Child> daycareChildren = getDaycareChildren(daycareId);
		Graph graph = new Graph();
		Node daycareNode = new Node("Daycare");
		int counter = 0;
		for(Child child : daycareChildren) {
			Node mainChildNode = new Node(child.getName());
			for(Child child2 : daycareChildren) {
				counter++;
				if(child.getId() != child2.getId()) {
					Node secondaryChildNode = new Node(child2.getName());
					mainChildNode.addDestination(secondaryChildNode, counter%10);
				}
			}
			daycareNode.addDestination(mainChildNode, counter%25);
			graph.addNode(mainChildNode);
		}
		graph.addNode(daycareNode);

		
		return calculateShortestPathFromSource(graph, daycareNode);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
}
