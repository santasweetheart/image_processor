package model;

/**
 * This class represents all methods available in the masking mode of this program.
 */
public interface MaskModel extends ImageModel {

  /**
   * Produces the image represented by the red values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeRedMask(Image mi);


  /**
   * Produces the image represented by the green values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeGreenMask(Image mi);


  /**
   * Produces the image represented by the blue values of the current image.
   * The red values are defined by the color representation.
   */
  public void makeBlueMask(Image mi);


  /**
   * Produces the image represented by the value of the current image.
   * The value is the maximum color component of each pixel.
   */
  public void imageValueMask(Image mi);

  /**
   * Produces the image represented by the intensity of the current image.
   * The intensity is the average of all color components.
   */
  public void imageIntensityMask(Image mi);

  /**
   * Produces the image represented by the luma of the current image.
   * The luma is the weighted sum of the color components.
   */
  public void imageLumaMask(Image mi);

  /**
   * Brightens the image by a specified amount.
   * Brightens the image by increasing the color values.
   * @param amount the amount to brighten the image by.
   */
  public void brightenMask(int amount, Image mi);


  /**
   * Darkens the image by a specified amount.
   * Darkens the image by decreasing the color values.
   * @param amount the amount to darken the image by.
   */
  public void darkenMask(int amount, Image mi);

  /**
   * Applies a blur effect to an image.
   * Blur effect is based on a 3x3 kernel.
   */
  public void gaussianBlurMask(Image mi);

  /**
   * Applies a sharpening effect to an image.
   * Sharpening effect is based on 5x5 kernel.
   */
  public void sharpenMask(Image mi);

  /**
   * Applies a linear filter to make the image greyscale;
   * Effect is based on a matrix of values applied to the image's color values.
   */
  public void greyscaleMask(Image mi);

  /**
   * Applies a linear filter to make the image sepia toned.
   * Effect is based on a matrix of values applied to the image's color values.
   */
  public void sepiaMask(Image mi);
}
