package com.share.ao;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author guozhe
 * @date 2019-12-03
 */
public class ContainerElementConstraintsAOTest {

    @Test
    public void listNotNull() {
        ContainerElementConstraintsAO containerElementConstraintsAO = new ContainerElementConstraintsAO();
        List<String> names = Lists.newArrayList();
        names.add("zhangsan");
        names.add(null);
        containerElementConstraintsAO.setNames(names);
        PrintUtil.print(ValidatorUtil.validate(containerElementConstraintsAO), "listNotNull");
    }

    @Test
    public void mapKeyNotNull() {
        ContainerElementConstraintsAO containerElementConstraintsAO = new ContainerElementConstraintsAO();
        List<String> names = Lists.newArrayList();
        names.add("zhangsan");
        containerElementConstraintsAO.setNames(names);

        Map<String, Integer> nameAgeMap = Maps.newHashMap();
        nameAgeMap.put("zhangsan", 10);
        nameAgeMap.put(null, 10);
        containerElementConstraintsAO.setNameAgeMap(nameAgeMap);
        PrintUtil.print(ValidatorUtil.validate(containerElementConstraintsAO), "mapKeyNotNull");
    }

    @Test
    public void mapValueMustPositive() {
        ContainerElementConstraintsAO containerElementConstraintsAO = new ContainerElementConstraintsAO();
        List<String> names = Lists.newArrayList();
        names.add("zhangsan");
        containerElementConstraintsAO.setNames(names);

        Map<String, Integer> nameAgeMap = Maps.newHashMap();
        nameAgeMap.put("zhangsan", -1);
        containerElementConstraintsAO.setNameAgeMap(nameAgeMap);
        PrintUtil.print(ValidatorUtil.validate(containerElementConstraintsAO), "mapValueMustPositive");
    }


}