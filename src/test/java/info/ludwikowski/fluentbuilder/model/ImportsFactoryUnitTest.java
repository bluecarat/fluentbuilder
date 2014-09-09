/*
 * Created by Jan van Esdonk for BLUECARAT AG
 */
package info.ludwikowski.fluentbuilder.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

/**
 * @author Jan van Esdonk
 */
public class ImportsFactoryUnitTest {

    @Test
    public void shouldCreateImportForClassInParentPackage() {
        final String type = "de.bluecarat.gpms.model.Usage";
        final String className = "de.bluecarat.gpms.model.module.AbstractPermissionModuleBuilder";
        final Collection<String> testImports = ImportsFactory.createNecessaryImportsForTypeInClass(type, className);
        assertThat(testImports.toString(), equalTo("[de.bluecarat.gpms.model.Usage]"));
    }

    @Test
    public void shouldAddDefaultImportsForSet() {
        final String type = "java.util.HashSet";
        final String className = "de.bluecarat.fluentbuilder.samples.Test";
        final Collection<String> imports = ImportsFactory.createNecessaryImportsForTypeInClass(type, className);
        assertThat(imports.contains("java.util.HashSet"), is(true));
        assertThat(imports.contains("java.util.Set"), is(true));
    }

    @Test
    public void shouldAddDefaultImportsForList() {
        final String type = "java.util.ArrayList";
        final String className = "de.bluecarat.fluentbuilder.samples.Test";
        final Collection<String> imports = ImportsFactory.createNecessaryImportsForTypeInClass(type, className);
        assertThat(imports.contains("java.util.ArrayList"), is(true));
        assertThat(imports.contains("java.util.List"), is(true));
    }

}
