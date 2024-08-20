package application.BackEnd;

public class PaneData {
private static final int OriginalTileSize = 16;
private static final int MinScale = 3;
private static final int MinScalingTileSize = OriginalTileSize*MinScale;
private static final int NumberRows = 12;
private static final int NumberColumn = 16;

private static final double MinWidth = NumberColumn*MinScalingTileSize;
private static final double MinHeight = NumberRows*MinScalingTileSize;

public static double GetMinWidth() { 
	return MinWidth;
}

public static double GetMinHeight() { 
	return MinHeight;
}

public static double GetOptimizedScale(double width, double height) {
    double scaleX = width / MinWidth;
    double scaleY = height / MinHeight;
    double scale = Math.max(scaleX, scaleY);
    System.out.println(MinHeight +"\t"+height);
    System.out.println(MinWidth +"\t"+width);
    scale = Math.min(scale, 5); 
    return scale;
}


}
