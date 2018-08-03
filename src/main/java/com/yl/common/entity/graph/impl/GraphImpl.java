package com.yl.common.entity.graph.impl;

import java.util.ArrayList;

import com.yl.common.entity.graph.Graph;
import com.yl.common.util.ArrayUtil;
import com.yl.common.expection.ConstructException;

public class GraphImpl<T extends Comparable<T>> implements Graph<T>{
	private static final long serialVersionUID = 1L;

	private int[][] matrix;
	
	private T[] points;
	
	public GraphImpl(int[][] matrix, T[] points) {
		if(!validateGraph(matrix, points)) 
			throw new ConstructException("邻接矩阵与点集长度应该相等且有效！");
		
		this.matrix = matrix;
		this.points = points;
	}
	
	@Override
	public int[][] getAdjacencyMatrix() {
		return matrix;
	}

	@Override
	public ArrayList<Integer>[] getAdjacencyList() {
		return ArrayUtil.arrayToList(ArrayUtil.intToInteger(matrix));
	}

	@Override
	public boolean validateGraph(int[][] matrix, T[] points) {
		if(matrix == null || points == null || matrix.length == 0 
				|| points.length == 0 || matrix.length != points.length)
			return false;
		
		if(ArrayUtil.isRepeat(points)) return false;
		Integer[][] matrixI = ArrayUtil.intToInteger(matrix);
		for(int i = 0; i < matrixI.length; i++) {
			if(ArrayUtil.isRepeat(matrixI[i])) return false;
			for(int j = 0; j < matrixI[i].length; j++) {
				if(matrixI[i][j] < 0 || matrixI[i][j] >= matrixI.length) return false;
			}
		}
		return true;
	}

	@Override
	public T[] getPoints() {
		return points;
	}

}
