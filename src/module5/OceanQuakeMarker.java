package module5;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	private UnfoldingMap map;
	private List<Marker> cityMarkers = new ArrayList<Marker>();
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
		if(this.getClicked()) {
//			System.out.println(this.getTitle() + "is clicked (from OQM)");
			for(Marker city: cityMarkers) {
				Location loc = city.getLocation();
				ScreenPosition pos = map.getScreenPosition(loc);
				pg.pushStyle();
				pg.fill(0, 0, 0);
				pg.line(x, y, pos.x-200, pos.y-50);
				pg.popStyle();
			}
			
//			double threatRadius = this.threatCircle();
//			float refX = this.getLocation().x;
//			float refY = this.getLocation().y+(float)threatRadius/2;
//			Location refLoc = new Location(refX, refY);
//			ScreenPosition refPos = map.getScreenPosition(refLoc);
//			
//			pg.pushStyle();
//			pg.noFill();
//			float R = refPos.y - y;
//			System.out.println(R);
//			pg.ellipse(x, y, R, R);
//			pg.popStyle();
		}
	}
	
	public void addCityInCirle(Marker cityMarker) {
		cityMarkers.add(cityMarker);
	}
	public void sendMap(UnfoldingMap mapUsed) {
		map = mapUsed;
	}

	

}
