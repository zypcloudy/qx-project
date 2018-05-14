package com.qianxun.entity;

public class AuthPermission {
    private Integer id;

    private String name;

    private Integer module;

    private String description;

    private String key;

    public AuthPermission(Integer id, String name, Integer module, String description, String key) {
        this.id = id;
        this.name = name;
        this.module = module;
        this.description = description;
        this.key = key;
    }

    public AuthPermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }
}