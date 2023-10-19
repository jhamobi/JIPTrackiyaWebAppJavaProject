package com.jhamobi.trackiya.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class Resources {
	/**
	 * A custom {@link Cell} used to render a string that contains the name of a
	 * color.
	 */
	static class ColorCell extends AbstractCell<String> {

		/**
		 * The HTML templates used to render the cell.
		 */
		interface Templates extends SafeHtmlTemplates {
			/**
			 * The template for this Cell, which includes styles and a value.
			 * 
			 * @param styles
			 *            the styles to include in the style attribute of the
			 *            div
			 * @param value
			 *            the safe value. Since the value type is
			 *            {@link SafeHtml}, it will not be escaped before
			 *            including it in the template. Alternatively, you could
			 *            make the value type String, in which case the value
			 *            would be escaped.
			 * @return a {@link SafeHtml} instance
			 */
			@SafeHtmlTemplates.Template("<div style=\"{0}\">{1}</div>")
			SafeHtml cell(SafeStyles styles, SafeHtml value);
		}

	    private static Templates templates = GWT.create(Templates.class);

		private static final List<String> COLORS = Arrays.asList("red", "green", "blue", "violet", "black", "gray");

		@Override
		public void render(Context context, String value, SafeHtmlBuilder sb) {
			 /*
		       * Always do a null check on the value. Cell widgets can pass null to
		       * cells if the underlying data contains a null, or if the data arrives
		       * out of order.
		       */
		      if (value == null) {
		        return;
		      }

		      // If the value comes from the user, we escape it to avoid XSS attacks.
		      SafeHtml safeValue = SafeHtmlUtils.fromString(value);

		      // Use the template to create the Cell's html.
		      SafeStyles styles = SafeStylesUtils.forTrustedColor(safeValue.asString());
		      SafeHtml rendered = templates.cell(styles, safeValue);
		      sb.append(rendered);

		}
		

	}

	public ImageResource getImageResource() {
		// TODO Auto-generated method stub
		return null;
	}

}
