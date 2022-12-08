package ${controller_package};

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webbusinessd.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("${request_mapping}")
public class ${entity_name}Controller {

    @Resource
    private ${entity_name}Service entityService;


    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ${create}Response create(@RequestBody ${create}Request createRequest) {
        ${create}Response.Builder resp = ${create}Response.newBuilder();
        resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.SUCC));
        ${entity_name} entity = Pbutil.pb2model(createRequest.getItem());
        if (!Objects.isNull(entity)) {
            int effectNum = entityService.insertSelective(entity);
            if (effectNum <= 0) {
                return resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.FAIL).setMsg("insert error").build()).build();
            }
        }
        return resp.build();
    }

     @PostMapping(value = "/delete", produces = "application/json", consumes = "application/json")
     public ${delete}Response delete(@RequestBody ${delete}Request deleteRequest) {
        ${delete}Response.Builder resp = ${delete}Response.newBuilder();
        resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.SUCC));
        int effectNum = entityService.deleteByPrimaryKey(deleteRequest.getId());
        if (effectNum <= 0) {
            return resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.FAIL).setMsg("delete error").build()).build();
        }
        return resp.build();
     }


      @PostMapping(value = "/update", produces = "application/json", consumes = "application/json")
      public ${update}Response update(@RequestBody ${update}Request updateRequest) {
         ${update}Response.Builder resp = ${update}Response.newBuilder();
         resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.SUCC));
         ${entity_name} entity = Pbutil.pb2model(updateRequest.getItem());
         if (!Objects.isNull(entity)) {
             entity.setUpdateTime(new Date());
             int effectNum = entityService.updateByPrimaryKeySelective(entity);
             if (effectNum <= 0) {
                 return resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.FAIL).setMsg("update error").build()).build();
             }
         }
         return resp.build();
      }


      @PostMapping(value = "/list", produces = "application/json", consumes = "application/json")
      public ${list}Response list(@RequestBody ${list}Request listRequest) {
          BaseListArg listArg = listRequest.getListArg();
          ${list}Response.Builder resp = ${list}Response.newBuilder();
          resp.setResp(BaseResponse.newBuilder().setCode(Pbutil.SUCC));
          if (listArg.getCountOnly()) {
            resp.setCount(entityService.getCount(null));
            return resp.build();
          }
          List<${entity_name}> entityList = entityService.selectList(null, listArg.getCount(), listArg.getStart());
          for (${entity_name} entity : entityList) {
            ${proto_obj_name} pbEntity = Pbutil.model2pb(entity);
            if (!Objects.isNull(pbEntity)) {
                resp.addItemList(pbEntity);
            }
          }
          return resp.build();
      }
}
