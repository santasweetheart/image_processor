package model;

/**
 * This class represents a Mask. It contains a method to apply the masking feature.
 */
public interface Mask {

  /**
   * Applies the given operation to the image based on the mask image.
   * @param original image before the applied operation.
   * @param mask the part of the image being adjusted.
   * @param adjusted The image with the operation applied.
   * @return the final image with the operations applied.
   */
  public Image apply(ImageState original, ImageState mask, ImageState adjusted);

}
