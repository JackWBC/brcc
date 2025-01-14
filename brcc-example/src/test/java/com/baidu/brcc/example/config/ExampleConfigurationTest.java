/*
 * Copyright (c) Baidu Inc. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.brcc.example.config;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.brcc.ConfigItemChangedCallable;
import com.baidu.brcc.DefaultConfigItemChangedCallable;

public class ExampleConfigurationTest {
    ExampleConfiguration exampleConfiguration = new ExampleConfiguration();

    @Test
    public void testInit() throws Exception {
        exampleConfiguration.init();
    }

    @Test
    public void testConfigItemChangedCallable() throws Exception {
        ConfigItemChangedCallable result = exampleConfiguration.configItemChangedCallable();
        Assert.assertEquals(DefaultConfigItemChangedCallable.class, result.getClass());
    }
}
