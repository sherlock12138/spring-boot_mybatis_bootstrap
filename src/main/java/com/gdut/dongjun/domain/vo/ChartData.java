package com.gdut.dongjun.domain.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName ChartDataFormat.java
 *@Time 2016年3月2日下午3:34:56
 *@Description TODO
 *@Version 1.0 Topview
 */
public class ChartData {

	private Map<String, Object> title = new HashMap<>(1);
	
	private Map<String, Object> tooltip = new HashMap<>(1);
	
	private Map<String, Object> legend = new HashMap<>();
	 
	private Map<String, Object> toolbox = new HashMap<>(1);
	
	private Map<String, Object> grid = new HashMap<>();
	
	private List<XAxis> xAxis = new ArrayList<>();
	
	private List<YAxis> yAxis = new ArrayList<>();
	
	private List<Object> series = new ArrayList<>();
	
	public ChartData() {
		
		title.put("text", "");
		tooltip.put("trigger", "axis");
		List<String> data = new ArrayList<>();
		data.add("A相"); 
		data.add("B相");
		data.add("C相");
		legend.put("data", data);
		Map<String, Object> feature = new HashMap<>(1);
		feature.put("saveAsImage", new HashMap<>());
		toolbox.put("feature", feature);
		grid.put("left", "");
		grid.put("right", "");
		grid.put("buttom", "");
		grid.put("containLabel", true);
		xAxis.add(new XAxis());
		yAxis.add(new YAxis());
		series.add(new ChaseData("A相"));
		series.add(new ChaseData("B相"));
		series.add(new ChaseData("C相"));
	}

	public List<XAxis> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<XAxis> xAxis) {
		this.xAxis = xAxis;
	}

	public List<YAxis> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<YAxis> yAxis) {
		this.yAxis = yAxis;
	}

	public List<Object> getSeries() {
		return series;
	}

	public void setSeries(List<Object> series) {
		this.series = series;
	}

	public Map<String, Object> getToolbox() {
		return toolbox;
	}

	public void setToolbox(Map<String, Object> toolbox) {
		this.toolbox = toolbox;
	}

	public Map<String, Object> getGrid() {
		return grid;
	}

	public void setGrid(Map<String, Object> grid) {
		this.grid = grid;
	}

	public Map<String, Object> getTitle() {
		return title;
	}

	public void setTitle(Map<String, Object> title) {
		this.title = title;
	}

	public Map<String, Object> getTooltip() {
		return tooltip;
	}

	public void setTooltip(Map<String, Object> tooltip) {
		this.tooltip = tooltip;
	}

	public Map<String, Object> getLegend() {
		return legend;
	}

	public void setLegend(Map<String, Object> legend) {
		this.legend = legend;
	}
	
	public class XAxis {
		
		private String type = "category";
		
		private boolean boundaryGap = false;
		
		private List<String> data = new ArrayList<>();

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public boolean getBoundaryGap() {
			return boundaryGap;
		}

		public void setBoundaryGap(boolean boundaryGap) {
			this.boundaryGap = boundaryGap;
		}

		public List<String> getData() {
			return data;
		}

		public void setData(List<String> data) {
			this.data = data;
		}
	}
	
	class YAxis {
		
		private String type = "value";
		
		public void setType(String type) {
			this.type = type;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public class ChaseData {
		
		private String name;
		
		private String type = "line";
		
		private String stack = "容量";
		
		private Map<String, Object> areaStyle = new HashMap<>(1);
		
		private List<Integer> data = new ArrayList<>();
		
		public ChaseData() {
			areaStyle.put("normal", new HashMap<>());
		}
		
		public ChaseData(String name) {
			this.name = name;
			areaStyle.put("normal", new HashMap<>());
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getStack() {
			return stack;
		}

		public void setStack(String stack) {
			this.stack = stack;
		}

		public Map<String, Object> getAreaStyle() {
			return areaStyle;
		}

		public void setAreaStyle(Map<String, Object> areaStyle) {
			this.areaStyle = areaStyle;
		}

		public List<Integer> getData() {
			return data;
		}

		public void setData(List<Integer> data) {
			this.data = data;
		}
	}
}
