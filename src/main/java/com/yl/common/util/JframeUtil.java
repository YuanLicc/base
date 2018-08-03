package com.yl.common.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * JFrame工具
 * @author YuanLi
 */
public class JframeUtil {

	public static JFrame initFrame(String title, int width, int height) {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setLayout(null);
		frame.setSize(width, height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	/**
	 * 设置窗口居中
	 * @param jFrame frame
	 * @param width frame宽度
	 * @param height frame长度
	 * @return farme
	 */
	public static JFrame centerScreen(JFrame jFrame, int width, int height) {
		if(jFrame == null) {
			return null;
		}
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();  
		jFrame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
		return jFrame;
	}
	
}
