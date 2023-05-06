package model;

/**
 * This interface represents methods that manipulate the dimensions of an image.
 */
public interface Scaler {

  /**
   * Deacrese the size of the image to the given width and height.
   * @param oldImage the image to be downscaled.
   * @return  a image with the given width and height.
   */
  public Image applyDownscale(Image oldImage);
}
