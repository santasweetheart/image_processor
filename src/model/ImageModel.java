package model;

/**
 *This interface represents the operations offered by the image model. One object of the model
 * represents one image.
 */
public interface ImageModel extends ImageModelState {

  /**
   * Produces the image represented by the red values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeRed();


  /**
   * Produces the image represented by the green values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeGreen();


  /**
   * Produces the image represented by the blue values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeBlue();


  /**
   * Produces the image represented by the value of the current image.
   * The value is the maximum color component of each pixel.
   */
  public void imageValue();

  /**
   * Produces the image represented by the intensity of the current image.
   * The intensity is the average of all color components.
   */
  public void imageIntensity();

  /**
   * Produces the image represented by the luma of the current image.
   * The luma is the weighted sum of the color components.
   */
  public void imageLuma();

  /**
   * Flips the image so that the left and right sides of the image are reversed.
   * The vertical component of each part of the image stays constant.
   */
  public void flipHorizontal();

  /**
   * Flips each image so that the top and bottom of the image are reversed.
   * The horizontal component of each part should stay constant.
   */
  public void flipVertical();

  /**
   * Brightens the image by a specified amount.
   * Brightens the image by increasing the color values.
   * @param amount the amount to brighten the image by.
   */
  public void brighten(int amount);


  /**
   * Darkens the image by a specified amount.
   * Darkens the image by decreasing the color values.
   * @param amount the amount to darken the image by.
   */
  public void darken(int amount);

  /**
   * Sets this image equal to the given image. This method is used for loading or overwriting an
   * image.
   * @param image the image that needs to be loaded.
   */
  public void overWriteImage(Image image);

  /**
   * Applies a blur effect to an image.
   * Blur effect is based on a 3x3 kernel.
   */
  public void gaussianBlur();

  /**
   * Applies a sharpening effect to an image.
   * Sharpening effect is based on 5x5 kernel.
   */
  public void sharpen();

  /**
   * Applies a linear filter to make the image greyscale;
   * Effect is based on a matrix of values applied to the image's color values.
   */
  public void greyscale();

  /**
   * Applies a linear filter to make the image sepia toned.
   * Effect is based on a matrix of values applied to the image's color values.
   */
  public void sepia();

  /**
   * Applies downscale to make the image smaller in width and/or height.
   * @param width width the image should be.
   * @param height height the image should be.
   */
  public void downscale(int width, int height);
}

