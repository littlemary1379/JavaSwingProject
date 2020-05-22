package utils;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResizeImage {
	public Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
}
