import java.io.File;

// The Facade
class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: Conversion process started for -> " + fileName + " to " + format);

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);

        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);

        AudioMixer mixer = new AudioMixer();
        String audioResult = mixer.fix(intermediateResult);

        System.out.println("VideoConversionFacade: Conversion completed successfully (" + format + ").");
        return new File("output." + format);
    }
}

