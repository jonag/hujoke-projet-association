package com.emn.fila2.hujoke.association.tools;

import java.io.IOException;
import java.util.Properties;

public class Prop {
	 /** Fichier de Properties */
    private static Properties propertiesResource = null;
 
 
    /** Nom de fichier de Properties */
    public final static String NOM_RESSOURCES = "properties.properties";
 
 
    /** Référence vers le fichier de définition des ressources de 
     * l'application 
     * @param cle String
     * @return String
     */
    public static String get(String cle) {
        return getPropertiesResource().getProperty(cle);
    }
 
 
 
    /** Référence vers le fichier de définition des ressources de 
     * l'application 
     * @return MessageResources
     */
    public static Properties getPropertiesResource() {
 
        if (propertiesResource == null) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(NOM_RESSOURCES);
            if (is != null) {
                propertiesResource = new Properties();
                try {
                    propertiesResource.load(is);
                } catch (IOException e) {
                	System.err.println(e);
                }
            }
 
        }
        return propertiesResource;
    }
 
}
