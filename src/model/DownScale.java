package model;

/**
 * This class contains all the methods necessary to downscale an image. It implements the Scaler
 * interface.
 */
public class DownScale implements Scaler {

  private int newWidth;
  private int newHeight;

  /**
   * Creates an instance of Downscale with the given with width and height.
   * @param newWidth the width the image should be after downscaling.
   * @param newHeight the height the image should be after downscaling.
   * @throws IllegalArgumentException when the width and height are less than 1.
   */
  public DownScale(int newWidth, int newHeight) throws IllegalArgumentException {
    if (newHeight < 1 || newWidth < 1) {
      throw new IllegalArgumentException("given dimensions are too small");
    }
    this.newWidth = newWidth;
    this.newHeight = newHeight;
  }

  /**
   * Decrease the size of the image to the given width and height.
   * @param oldImage the image to be downscaled.
   * @return  a image with the given width and height.
   */
  public Image applyDownscale(Image oldImage) {
    int oldHeight = oldImage.getImageHeight();
    int oldWidth = oldImage.getImageWidth();

    if (oldHeight < newHeight || oldWidth < newWidth) {
      throw new IllegalArgumentException("Dimensions must be smaller than the original image.");
    }

    Image newImage = new Image(new Pixel[newHeight][newWidth]);

    //1. map each pixel from the new image to a pixel in the old image
    for (int r = 0; r < newHeight; r ++) {
      for (int c = 0; c < newWidth; c ++) {
        double xOld = findCorrespondingX(c, oldWidth);
        double yOld = findCorrespondingY(r, oldHeight);

        //2. Use the colors from the corresponding pixel in the original image and add pixel to
        //new image
        newImage.getImage()[r][c] = getDownsizeColor(yOld,xOld,oldImage);
      }
    }
    return  newImage;
  }

  //Given a x-coordinate from the downsized image, find the corresponding x-coordinate in the
  //original image
  private double findCorrespondingX(int xNew, int oldImageWidth) {
    return (double) (xNew * oldImageWidth) / this.newWidth;
  }

  ////Given a y-coordinate from the downsized image, find the corresponding y-coordinate in the
  // original image
  private double findCorrespondingY(int yNew, int oldImageHeight) {
    return (double) (yNew * oldImageHeight) / this.newHeight;
  }


  //given the corresponding pixel coordinate in the original image, get the color for the pixel
  //in the downsized image
  private Pixel getDownsizeColor(double y, double x, Image oldImage) {
    //1. find the floor and ceiling of the given coordinate
    int floorX = (int) Math.floor(x);
    int floorY = (int) Math.floor(y);
    int ceilX = (int) Math.ceil(x);
    int ceilY = (int) Math.ceil(y);

    //2. find four locations around the given coordinates using the floors and ceilings (in the
    //oldImage
    Pixel a = oldImage.getImage()[floorY][floorX];
    Pixel b = oldImage.getImage()[floorY][ceilX];
    Pixel c = oldImage.getImage()[ceilY][floorX];
    Pixel d = oldImage.getImage()[ceilY][ceilX];

    //3. Calculate the color of the pixel in the downsized image

    //compute for red, blue, and green components
    int newRed = computeColorComponent(a.getRed(), b.getRed(), c.getRed(), d.getRed(),
        floorX, floorY, ceilX, ceilY, x, y);

    int newBlue = computeColorComponent(a.getBlue(), b.getBlue(), c.getBlue(), d.getBlue(),
        floorX, floorY, ceilX, ceilY, x, y);

    int newGreen = computeColorComponent(a.getGreen(), b.getGreen(), c.getGreen(), d.getGreen(),
        floorX, floorY, ceilX, ceilY, x, y);

    //create new pixel with the computed color
    return new PixelRGB(newRed, newGreen, newBlue);
  }



  private int computeColorComponent(int aColor, int bColor, int cColor, int dColor, int floorX,
      int floorY, int ceilX ,int ceilY, double x, double y) {

    double m = bColor * (x - floorX) +  aColor * (ceilX - x);
    double n = dColor * (x - floorX) + cColor * (ceilX - x);

    if (floorX == ceilX && floorY == ceilY) {
      return aColor;
    } else if (floorX == ceilX) {
      m = bColor;
      n = dColor;
    } else if (floorY == ceilY) {
      return (int) n;
    }

    return  (int) (n * (y - floorY) + m * (ceilY - y));
  }

}
