package com.jayway.jsonpath.internal.filter;

import com.jayway.jsonpath.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;

public class JsonNodeTest extends BaseTest {

    private ValueNodes.JsonNode uut;

    @Before
    public void setup() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", "1");
        map.put("name", "Joe");
        uut = new ValueNodes.JsonNode(map);
    }

    @Test
    public void should_is_map_return_true() {
        // when
        boolean result = uut.isMap(null); // context is irrelevant in this case - it's not used, so can be set as null

        // then
        assertTrue(result);
    }

    @Test
    public void should_throw_exception_when_map_passed_to_is_empty_method() {
        // when
        assertThatThrownBy(() -> uut.isEmpty(null)) // context is irrelevant in this case - it's not used, so can be set as null
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("class java.util.LinkedHashMap cannot be cast to class java.util.Collection " +
                        "(java.util.LinkedHashMap and java.util.Collection are in module java.base of loader 'bootstrap')");
    }
}
