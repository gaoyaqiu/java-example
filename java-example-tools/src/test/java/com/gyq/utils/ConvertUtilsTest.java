package com.gyq.utils;

import com.gyq.model.Bar;
import com.gyq.model.Foo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ConvertUtilsTest {

    @Test
    public void assertCopyProperties() {

        Foo foo = new Foo(1L, "张三");
        for (int i = 0; i < 10; i++) {
            ConvertUtils.copyProperties(foo, Bar.class);
        }

        assertEquals(1, ConvertUtils.size());
    }
}
