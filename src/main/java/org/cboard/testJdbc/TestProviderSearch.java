package org.cboard.testJdbc;

import org.cboard.dataprovider.DataProvider;
import org.cboard.dataprovider.annotation.ProviderName;
import org.reflections.Reflections;
import org.reflections.Store;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Administrator on 2017/5/15.
 */
public class TestProviderSearch {

    public static void main(String[] args) {
        //Reflections.getTypes
        Reflections reflections = new Reflections("org.cboard");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(RestController.class);
        for(Class c : typesAnnotatedWith) {
            System.out.println(c.getSimpleName());
        }

        Store types = reflections.getStore();
        System.out.println(types.toString() + " " + types.keySet());
        Set<Class<?>> classSet = new Reflections("org.cboard").getTypesAnnotatedWith(ProviderName.class);
        for (Class c : classSet) {
            if (!c.isAssignableFrom(DataProvider.class)) {
                //providers.put(((ProviderName) c.getAnnotation(ProviderName.class)).name(), c);
                System.out.println(c.getName() + " " + c.getCanonicalName() + " " + c.getSimpleName());
            } else {
                System.out.println("自定义DataProvider需要继承org.cboard.dataprovider.DataProvider");
            }
        }
    }
}
