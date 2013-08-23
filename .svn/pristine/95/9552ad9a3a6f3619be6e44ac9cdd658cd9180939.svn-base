package com.boventech.cms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boventech.cms.action.util.FlashMessageConstants;
import com.boventech.cms.module.DataType;
import com.boventech.cms.service.DataTypeService;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireRight;

@Results({
    @Result(name = "index", type = "dispatcher", location = "/page/admin/datatype/list.jsp"),
    @Result(name = "edit", type = "dispatcher", location = "/page/admin/datatype/edit.jsp"),
    @Result(name = "new", type = "dispatcher", location = "/page/admin/datatype/new.jsp"),
    @Result(name = "list", type = "redirect", location = "${listLocation}")
})
@RequireRight(right = UserRight.SUPERADMIN)
public abstract class DataTypeAction<T extends DataType> extends AdminAction{

    /**
     * 
     */
    private static final long serialVersionUID = 7685308739688854186L;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataTypeAction.class);
    
    private String typeName;
    
    private Integer typeId;
    
    private String[] selectType;
    
    private T currentType;
    
    private DataTypeService<T> dataTypeService;
    
    private List<T> types;
    
    private String action;
    
    private String typename;
    
    public DataTypeAction(){
        setAction();
        setTypename();
    }
    
    public String shiftUp(){
        this.typeId = getIntegerId();
        T upType = this.dataTypeService.findById(typeId);
        if(upType != null){
            T downType = this.dataTypeService.getByPosition(upType.getPosition() - 1);
            if(downType != null){
                shift(downType, upType);
            }
        }
        return redirect();
    }
    
    public String shiftDown(){
        this.typeId = getIntegerId();
        T downType = this.dataTypeService.findById(typeId);
        if(downType != null){
            T upType = this.dataTypeService.getByPosition(downType.getPosition() + 1);
            if(upType != null){
                shift(downType, upType);
            }
        }
        return redirect();
    }
    
    private void shift(T downType, T upType) {
        downType.setPosition(upType.getPosition());
        this.dataTypeService.update(downType);
        upType.setPosition(upType.getPosition() - 1);
        this.dataTypeService.update(upType);
    }
    
    public void delete(){
        this.typeId = getIntegerId();
        if(this.typeId < 0 && SELECTED.equals(getId())){
            this.dataTypeService.deleteSelected(this.selectType);
        }else{
            T type = this.dataTypeService.findById(this.typeId);
            if(type != null){
                try {
					this.dataTypeService.delete(type);
				} catch (Exception e) {
					LOGGER.info(e.getMessage());
					addFlashMessage(getText(FlashMessageConstants.BATCH_DELETE_FAILURE));
				}
            }
        }
        this.dataTypeService.cleanPosition();
        redirect();
    }
    
    @Override
    public HttpHeaders create() {
        T type = newInstance();
        type.setName(this.typeName);
        type.setPosition(this.dataTypeService.count() + 1);
        this.dataTypeService.save(type);
        return new DefaultHttpHeaders(LIST).disableCaching();
    }

    public abstract T newInstance();
    
    @Override
    public String edit() {
        this.typeId = getIntegerId();
        this.currentType = this.dataTypeService.findById(this.typeId);
        if(this.currentType != null)
            return EDIT;
        return "404";
    }
    
    @Override
    public HttpHeaders index() {
        this.types = this.dataTypeService.listByPosition(false);
        return new DefaultHttpHeaders(INDEX).disableCaching();
    }
    
    @Override
    public String update() {
        this.typeId = getIntegerId();
        this.currentType = this.dataTypeService.findById(this.typeId);
        this.currentType.setName(this.typeName);
        this.dataTypeService.update(this.currentType);
        return LIST;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<T> getTypes() {
        return types;
    }

    public void setSelectType(String[] selectType) {
        this.selectType = selectType;
    }

    public void initDataTypeService(DataTypeService<T> dataTypeService) {
        this.dataTypeService = dataTypeService;
    }

    public T getCurrentType() {
        return currentType;
    }

    public String getAction() {
        return action;
    }

    private void setAction(){
        this.action = initCurrentAction();
    }
    
    public abstract String initCurrentAction();

    public String getTypename() {
        return typename;
    }

    public void setTypename() {
        this.typename = initCurrentTypeName();
    }

    public abstract String initCurrentTypeName();

	@Override
	public HttpHeaders editNew() {
		return new DefaultHttpHeaders(NEW).disableCaching();
	}
	
	public String getListLocation(){
		return initCurrentAction();
	}
}
