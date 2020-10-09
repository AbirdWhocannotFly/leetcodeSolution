package com.leetcode.solution.daily.han.entity;

/**
 * @ProjectName
 * @ClassName
 * @ClassDescription TODO
 * @CreateBy
 * @CreateAt
 * @Version 1.0
 */
public class Person {
        private String name;
    private String  add;

        public Person(String name, String add) {
            this.name = name;
            this.add = add;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
}
