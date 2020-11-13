package us.hemdgang.elcliento.utils;

public class ColorUtils {

    public static int rainbowEffect() {
	float x = (float) (System.currentTimeMillis() * 0.5 % 2000L) / 1000.0F;
	int red = (int) (255 * (0.5F + 0.5F * (float) Math.sin(x * Math.PI)));
	int green = (int) (255 * (0.5F + 0.5F * (float) Math.sin((x + 1.3333334F) * Math.PI)));
	int blue = (int) (255 * (0.5F + 0.5F * (float) Math.sin((x + 2.6666667F) * Math.PI)));
	int rgb = red;
	rgb = (rgb << 8) + green;
	rgb = (rgb << 8) + blue;
	return rgb;
    }
}
