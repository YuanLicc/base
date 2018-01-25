package com.yl.base.entity.graph.impl;

import java.util.Map;

import com.yl.base.entity.point.Point;

public class WeightedGraph<T extends Comparable<T>> extends GraphImpl<T>{
	private static final long serialVersionUID = 1L;

	private Map<Point<Integer, Integer>, Integer> edgeWeight;
	
	public WeightedGraph(int[][] matrix, T[] points , Map<Point<Integer, Integer>, Integer> edgeWeight) {
		super(matrix, points);
		this.edgeWeight = edgeWeight;
	}

	public Map<Point<Integer, Integer>, Integer> getEdgeWeight() {
		return edgeWeight;
	}

}
