package ${service_package};

import ${entity_package}.${entity_name};
import ${base_service_package}.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ${entity_name}ServiceImpl extends BaseServiceImpl<${entity_name}, ${id_type}> implements ${entity_name}Service {

}
