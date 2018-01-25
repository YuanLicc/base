package com.yl.base.entity.graph;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 实现图应该实现此接口
 * @author YuanLi
 */
public interface Graph<T> extends Serializable{

	/**
	 * 返回图的邻接矩阵
	 * @return 图的邻接矩阵
	 */
	int[][] getAdjacencyMatrix();
	
	/**
	 * 返回图的邻接表
	 * @return 图的邻接表
	 */
	ArrayList<Integer>[] getAdjacencyList();
	
	/**
	 * 验证图的邻接矩阵与点的正确性
	 * @param matrix 图的邻接矩阵
	 * @param points 图的点集
	 * @return 图的邻接矩阵与点的正确性
	 */
	boolean validateGraph(int[][] matrix, T[] points);
	
	/**
	 * 返回图的点集
	 * @return 图的点集
	 */
	T[] getPoints();
}
