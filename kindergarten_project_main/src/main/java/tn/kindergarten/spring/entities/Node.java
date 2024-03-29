package tn.kindergarten.spring.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    
    private String name;
    
    private List<Node> shortestPath = new LinkedList<>();
        
    private double distance = Double.MAX_VALUE;
    private String Maps;
    
    public String getMaps() {
		return Maps;
	}

	public void setMaps(String maps) {
		Maps = maps;
	}

	Map<Node, Double> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, double distance) {
        adjacentNodes.put(destination, distance);
    }
 
    public Node(String name,String Maps) {
        this.name = name;
        this.Maps = Maps;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Map<Node, Double> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Double> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
    
}