package model;

/**
 * This method is an implementation of the Mask interface.
 */
public class MaskImpl implements Mask {

  @Override
  public Image apply(ImageState original, ImageState mask, ImageState adjusted) {

    int width = original.getImageWidth();
    int height = original.getImageHeight();

    Pixel[][] oPixels = original.getImage();
    Pixel[][] mPixels = mask.getImage();
    Pixel[][] aPixels = adjusted.getImage();

    Pixel[][] i = new Pixel[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        System.out.println(row + ", " + col);
        i[row][col] = this.pixelApply(oPixels[row][col], mPixels[row][col], aPixels[row][col]);
      }
    }
    Image finalImage = new Image(i);
    return finalImage;
  }


  private Pixel pixelApply(Pixel original, Pixel mask, Pixel adjusted) {
    if (this.isBlack(mask)) {
      return adjusted;
    }
    else {
      return original;
    }
  }

  private boolean isBlack(Pixel mask) {
    return ((mask.getRed() == 255) && (mask.getBlue() == 255) && (mask.getGreen() == 255));
  }
}
