package eapli.base.Utils;

    import java.awt.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
    public class ColorConverter implements AttributeConverter<Color, String> {

        private static final String SEPARATOR = "-";
        private String cor="" ;

        /**
         * Convert Color object to a String
         * with format red-green-blue-alpha
         */
        @Override
        public String convertToDatabaseColumn(Color color) {
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=255,b=255]")){
                cor = "Branco ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=192,g=192,b=192]")){
                cor = "Cinzento Claro ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=128,g=128,b=128]")){
                cor = "Cinzento ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=64,g=64,b=64]")){
                cor = "Cinzento Escuro ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=0,b=0]")){
                cor = "Preto ";
            }

            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=0,b=0]")){
                cor = "Vermelho ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=175,b=175]")){
                cor = "Rosa ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=200,b=0]")){
                cor = "Laranja ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=255,b=0]")){
                cor = "Amarelo ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=255,b=0]")){
                cor = "Verde ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=0,b=255]")){
                cor = "Magenta ";
            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=255,b=255]")){
                cor = "Ciano ";

            }
            if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=0,b=255]")){
                cor = "Azul ";
            }


            StringBuilder sb = new StringBuilder();
            sb.append(cor).append(SEPARATOR)
                    .append(color.getRed()).append(SEPARATOR)
                    .append(color.getGreen())
                    .append(SEPARATOR)
                    .append(color.getBlue())
                    .append(SEPARATOR)
                    .append(color.getAlpha());
            return sb.toString();
        }

        /**
         * Convert a String with format red|green|blue|alpha
         * to a Color object
         */
        @Override
        public Color convertToEntityAttribute(String colorString) {
            String[] rgb = colorString.split(SEPARATOR);
            return new Color(Integer.parseInt(rgb[1]),
                    Integer.parseInt(rgb[2]),
                    Integer.parseInt(rgb[3]),
                    Integer.parseInt(rgb[4]));
        }

    }
