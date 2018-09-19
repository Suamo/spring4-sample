package ua.antonio.spring4sample.domain.types;

import java.time.LocalDate;
import java.util.*;

/**
 * Sample of Spring converters usage
 */
public class AllTypes {
    private String stringValue;

    private boolean booleanValue;

    private byte byteValue;
    private short shortValue;
    private int intValue;
    private long longValue;

    private Integer integer;

    private List list;
    private Set set;
    private Map map;

    private Properties propertiesFromInnerBlock;
    private Properties propertiesFromFile;

    private Date createdWithStandardDateConverter;
    private LocalDate createdWithCustomDateConverter;

    private Object nullObject;

    private Thread createdWithFactoryMethod;
    private Thread createdWithFactoryBean;

    private User parentUser;
    private User childUserWithInheritedAge;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public short getShortValue() {
        return shortValue;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getPropertiesFromInnerBlock() {
        return propertiesFromInnerBlock;
    }

    public void setPropertiesFromInnerBlock(Properties propertiesFromInnerBlock) {
        this.propertiesFromInnerBlock = propertiesFromInnerBlock;
    }

    public Properties getPropertiesFromFile() {
        return propertiesFromFile;
    }

    public void setPropertiesFromFile(Properties propertiesFromFile) {
        this.propertiesFromFile = propertiesFromFile;
    }

    public Date getCreatedWithStandardDateConverter() {
        return createdWithStandardDateConverter;
    }

    public void setCreatedWithStandardDateConverter(Date createdWithStandardDateConverter) {
        this.createdWithStandardDateConverter = createdWithStandardDateConverter;
    }

    public LocalDate getCreatedWithCustomDateConverter() {
        return createdWithCustomDateConverter;
    }

    public void setCreatedWithCustomDateConverter(LocalDate createdWithCustomDateConverter) {
        this.createdWithCustomDateConverter = createdWithCustomDateConverter;
    }

    public Object getNullObject() {
        return nullObject;
    }

    public void setNullObject(Object nullObject) {
        this.nullObject = nullObject;
    }

    public Thread getCreatedWithFactoryMethod() {
        return createdWithFactoryMethod;
    }

    public void setCreatedWithFactoryMethod(Thread createdWithFactoryMethod) {
        this.createdWithFactoryMethod = createdWithFactoryMethod;
    }

    public Thread getCreatedWithFactoryBean() {
        return createdWithFactoryBean;
    }

    public void setCreatedWithFactoryBean(Thread createdWithFactoryBean) {
        this.createdWithFactoryBean = createdWithFactoryBean;
    }

    public User getParentUser() {
        return parentUser;
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    public User getChildUserWithInheritedAge() {
        return childUserWithInheritedAge;
    }

    public void setChildUserWithInheritedAge(User childUserWithInheritedAge) {
        this.childUserWithInheritedAge = childUserWithInheritedAge;
    }
}
