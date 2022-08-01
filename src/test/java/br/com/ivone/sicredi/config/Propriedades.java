package br.com.ivone.sicredi.config;

import java.util.Properties;

import lombok.SneakyThrows;

/**
 * <p>Responsavel pela leitura do arquivo {@linkplain /application.properties}.
 */
public class Propriedades {

    private static final Properties PROPERTIES = inicializarPropriedades();

    /**
     * <p>Recupera o valor no arquivo {@linkplain /application.properties}.</p>
     * @param propriedade nome da propriedade no arquivo {@linkplain /application.properties}
     * @return valor da {@code propriedade} no arquivo {@linkplain /application.properties}
     */
    public static String propriedade(String propriedade) {
        return PROPERTIES.getProperty(propriedade);
    }

    // Le o arquivo de propriedades e carrega a variavel {@code PROPERTIES}.
    @SneakyThrows
    private static Properties inicializarPropriedades() {

        final var properties = new Properties();
        properties.load(Propriedades.class.getResourceAsStream("/application.properties"));

        return properties;

    }

}