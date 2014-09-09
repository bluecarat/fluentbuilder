/*
 * Created on 03-04-2013 17:53:37 by Andrzej Ludwikowski
 */
/*
 * Modified by Jan van Esdonk for BLUECARAT AG
 */
package info.ludwikowski.fluentbuilder.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class provides constants for the FluentBuilderGenerator.
 * @author Andrzej Ludwikowski
 */
public final class Constants {

    public static final List<String> SUPPORTED_VARARGS_COLLECTIONS = getSupportedCollections();

    private Constants() {

    }

    private static List<String> getSupportedCollections() {
        final List<String> collections = new LinkedList<String>();
        collections.add(Set.class.getName());
        collections.add(List.class.getName());
        return collections;
    }

}
