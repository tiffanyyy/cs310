/** Contains a list of features which can be displayed.
 * 
 */

package cs310.creativeteamname.client;

import java.util.Set;
import java.util.TreeSet;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FeatureList {
	
	VerticalPanel panelForDisplay;
	Set<FeatureOption> featureOptions;
	String title;
	
	/** Create a new feature list with a given title.
	 * 
	 * @param title the category title of the feature list.
	 */
	public FeatureList(String title) {
		this.title = title;
		Label titleLabel = new Label(title);
		
		// Got line from http://stackoverflow.com/questions/6405581/how-can-i-change-the-font-size-of-a-gwt-label-object-dynamically
		// titleLabel.getElement().getStyle().setFontSize(1.2, Unit.EM);
		
		titleLabel.addStyleName("filterCategoryLabel");
		
		
		panelForDisplay = new VerticalPanel();
		panelForDisplay.add(titleLabel);
		featureOptions = new TreeSet<FeatureOption>();
		panelForDisplay.setWidth("210px");
		panelForDisplay.setSpacing(5);
		panelForDisplay.setStyleName("featurelist");
	}
	
	/** Add a feature option to this list of features.
	 * 
	 * @param featureOption the name of the feature option.
	 */
	public void addFeatureOption(String featureName, boolean isNeighborhood) {
		FeatureOption featureOption = new FeatureOption(featureName, isNeighborhood);
		featureOptions.add(featureOption);
	}
	
	/** Get the list of features to display.
	 * 
	 * @return the feature option panel.
	 */
	public VerticalPanel getWidget() {
		addFeaturesToPanel();
		return panelForDisplay;
	}
	
	/** Determine the number of features in this list.
	 * 
	 * @return the number of features.
	 */
	public int getNumFeatures() {
		return featureOptions.size();
	}
	
	/** Add the features in the list to the panel.
	 * 
	 */
	private void addFeaturesToPanel() {
		for(FeatureOption featureOption : featureOptions) {
			HorizontalPanel feature = featureOption.getFeatureToDisplay();
			panelForDisplay.add(feature);
		}
	}
}
