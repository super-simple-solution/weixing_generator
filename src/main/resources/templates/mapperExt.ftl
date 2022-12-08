<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapper_package_name}.${entity_name}Mapper">
    <select id="selectList" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${table_name}
        <where>
            <if test="record != null">
            </if>
        </where>
        <if test=" limit != 0 ">
            limit <#noparse>#{limit}</#noparse> offset <#noparse>#{offset}</#noparse>
        </if>
    </select>


    <select id="getCount" resultType="${id_type}">
        select
        count(*)
        from ${table_name}
        <where>
            <if test="record != null">

            </if>
        </where>
    </select>

</mapper>