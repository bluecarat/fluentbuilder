/*
 * Created by Jan van Esdonk for BLUECARAT AG
 */
package info.ludwikowski.fluentbuilder.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Test;

/**
 * @author Jan van Esdonk
 */
public class TypeUtilsUnitTest {

    static String staticString;
    final String finalString = "Final";
    @SuppressWarnings("unused")
    private String norString;

    @Test
    public void shouldCheckIfElementIsStaticOrFinal() {

        try {
            // given
            Field[] fields = TypeUtilsUnitTest.class.getDeclaredFields();
            final Field staticField = fields[0];
            final Field finalField = fields[1];
            final Field norField = fields[2];
            // when
            final boolean isFinal = TypeUtils.isStaticOrFinal(finalField);
            final boolean isStatic = TypeUtils.isStaticOrFinal(staticField);
            final boolean isNor = TypeUtils.isStaticOrFinal(norField);

            // then
            assertTrue(isFinal);
            assertTrue(isStatic);
            assertFalse(isNor);
        } catch (Exception e) {
            fail("Fields not found");
        }

    }

    @Test
    public void shouldReturnTrueForList() {
        assertThat(TypeUtils.isList("java.util.List<String>"), is(true));
    }

    @Test
    public void shouldReturnFalseForSimpleTypeAndNotList() {
        assertThat(TypeUtils.isList("java.lang.String"), is(false));
    }

    @Test
    public void shouldReturnTrueForSet() {
        assertThat(TypeUtils.isSet("java.util.Set<String>"), is(true));
    }

    @Test
    public void shouldReturnFalseForSimpleTypeAndNotSet() {
        assertThat(TypeUtils.isSet("java.lang.String"), is(false));
    }

    @Test
    public void shouldReturnTrueForPrimitiveType() {
        assertThat(TypeUtils.isPrimitiveType("char"), is(true));
    }
}
