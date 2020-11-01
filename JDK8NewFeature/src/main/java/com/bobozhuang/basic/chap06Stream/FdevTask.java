package main.java.com.bobozhuang.basic.chap06Stream;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class FdevTask implements Serializable {

    private static final long serialVersionUID = -5627804709275451840L;

    private String id;

    private String name;

    private String redmine_id;

    private String desc;

    private String[] spdb_master;

    private String[] master;

    private String group;

    private String project_id;

    private String project_name;

    private String plan_start_time;

    private String start_time;

    private String plan_inner_test_time;

    private String start_inner_test_time;

    private String plan_uat_test_start_time;

    private String plan_uat_test_stop_time;

    private String start_uat_test_time;

    private String stop_uat_test_time;

    private String plan_rel_test_time;

    private String start_rel_test_time;

    private String plan_fire_time;

    private String fire_time;

    private String stage;

    private String feature_branch;

    private String sit_merge_id;

    private String uat_merge_id;

    private String[] developer;

    private String[] tester;

    private String[] doc;

    private String[] concern;

    private String creator;

    private String uat_testObject;

    private String rqrmnt_no;

    private String[] tag;

    private String uat_test_time;

    private String folder_id;

    private String reviewer;

    private String review_status;

    private Map<String, List<String>> doc_uploader;

    private String system_remould;

    private String impl_data;

    private String reinforce;

    private String test_merge_id;

    private String sonarId;

    private String scanTime;

    private String difficulty_desc;

    private Map<String, List<Map<String, String>>> designMap;
    /**
     * 有无代码变更的状态
     */
    private Integer taskType;


    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    private List<Map<String, String>> newDoc;

    public List<Map<String, String>> getNewDoc() {
        return newDoc;
    }

    public void setNewDoc(List<Map<String, String>> newDoc) {
        this.newDoc = newDoc;
    }

    private String designRemark;

    public String getDesignRemark() {
        return designRemark;
    }

    public void setDesignRemark(String designRemark) {
        this.designRemark = designRemark;
    }
    public Map<String, List<Map<String, String>>> getDesignMap() {
        return designMap;
    }
    public void setDesignMap(Map<String, List<Map<String, String>>> designMap) {
        this.designMap = designMap;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    private String modify_reason;

    public FdevTask() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedmine_id() {
        return redmine_id;
    }

    public void setRedmine_id(String redmine_id) {
        this.redmine_id = redmine_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getSpdb_master() {
        return spdb_master;
    }

    public void setSpdb_master(String[] spdb_master) {
        this.spdb_master = spdb_master;
    }

    public String[] getMaster() {
        return master;
    }

    public void setMaster(String[] master) {
        this.master = master;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getPlan_start_time() {
        return plan_start_time;
    }

    public void setPlan_start_time(String plan_start_time) {
        this.plan_start_time = plan_start_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getPlan_inner_test_time() {
        return plan_inner_test_time;
    }

    public void setPlan_inner_test_time(String plan_inner_test_time) {
        this.plan_inner_test_time = plan_inner_test_time;
    }

    public String getStart_inner_test_time() {
        return start_inner_test_time;
    }

    public void setStart_inner_test_time(String start_inner_test_time) {
        this.start_inner_test_time = start_inner_test_time;
    }

    public String getPlan_uat_test_start_time() {
        return plan_uat_test_start_time;
    }

    public void setPlan_uat_test_start_time(String plan_uat_test_start_time) {
        this.plan_uat_test_start_time = plan_uat_test_start_time;
    }

    public String getPlan_uat_test_stop_time() {
        return plan_uat_test_stop_time;
    }

    public void setPlan_uat_test_stop_time(String plan_uat_test_stop_time) {
        this.plan_uat_test_stop_time = plan_uat_test_stop_time;
    }

    public String getStart_uat_test_time() {
        return start_uat_test_time;
    }

    public void setStart_uat_test_time(String start_uat_test_time) {
        this.start_uat_test_time = start_uat_test_time;
    }

    public String getStop_uat_test_time() {
        return stop_uat_test_time;
    }

    public void setStop_uat_test_time(String stop_uat_test_time) {
        this.stop_uat_test_time = stop_uat_test_time;
    }

    public String getPlan_rel_test_time() {
        return plan_rel_test_time;
    }

    public void setPlan_rel_test_time(String plan_rel_test_time) {
        this.plan_rel_test_time = plan_rel_test_time;
    }

    public String getStart_rel_test_time() {
        return start_rel_test_time;
    }

    public void setStart_rel_test_time(String start_rel_test_time) {
        this.start_rel_test_time = start_rel_test_time;
    }

    public String getPlan_fire_time() {
        return plan_fire_time;
    }

    public void setPlan_fire_time(String plan_fire_time) {
        this.plan_fire_time = plan_fire_time;
    }

    public String getFire_time() {
        return fire_time;
    }

    public void setFire_time(String fire_time) {
        this.fire_time = fire_time;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFeature_branch() {
        return feature_branch;
    }

    public void setFeature_branch(String feature_branch) {
        this.feature_branch = feature_branch;
    }

    public String getSit_merge_id() {
        return sit_merge_id;
    }

    public void setSit_merge_id(String sit_merge_id) {
        this.sit_merge_id = sit_merge_id;
    }

    public String getUat_merge_id() {
        return uat_merge_id;
    }

    public void setUat_merge_id(String uat_merge_id) {
        this.uat_merge_id = uat_merge_id;
    }

    public String[] getDeveloper() {
        return developer;
    }

    public void setDeveloper(String[] developer) {
        this.developer = developer;
    }

    public String[] getTester() {
        return tester;
    }

    public void setTester(String[] tester) {
        this.tester = tester;
    }

    public String[] getDoc() {
        return doc;
    }

    public void setDoc(String[] doc) {
        this.doc = doc;
    }

    public String[] getConcern() {
        return concern;
    }

    public void setConcern(String[] concern) {
        this.concern = concern;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUat_testObject() {
        return uat_testObject;
    }

    public void setUat_testObject(String uat_testObject) {
        this.uat_testObject = uat_testObject;
    }

    public String getRqrmnt_no() {
        return rqrmnt_no;
    }

    public void setRqrmnt_no(String rqrmnt_no) {
        this.rqrmnt_no = rqrmnt_no;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public String getUat_test_time() {
        return uat_test_time;
    }

    public void setUat_test_time(String uat_test_time) {
        this.uat_test_time = uat_test_time;
    }

    public String getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(String folder_id) {
        this.folder_id = folder_id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReview_status() {
        return review_status;
    }

    public void setReview_status(String review_status) {
        this.review_status = review_status;
    }

    public Map<String, List<String>> getDoc_uploader() {
        return doc_uploader;
    }

    public void setDoc_uploader(Map<String, List<String>> doc_uploader) {
        this.doc_uploader = doc_uploader;
    }

    public String getSystem_remould() {
        return system_remould;
    }

    public void setSystem_remould(String system_remould) {
        this.system_remould = system_remould;
    }

    public String getImpl_data() {
        return impl_data;
    }

    public void setImpl_data(String impl_data) {
        this.impl_data = impl_data;
    }

    public String getReinforce() {
        return reinforce;
    }

    public void setReinforce(String reinforce) {
        this.reinforce = reinforce;
    }

    public String getTest_merge_id() {
        return test_merge_id;
    }

    public void setTest_merge_id(String test_merge_id) {
        this.test_merge_id = test_merge_id;
    }

    public String getSonarId() {
        return sonarId;
    }

    public void setSonarId(String sonarId) {
        this.sonarId = sonarId;
    }

    public String getDifficulty_desc() {
        return difficulty_desc;
    }

    public void setDifficulty_desc(String difficulty_desc) {
        this.difficulty_desc = difficulty_desc;
    }

    public String getModify_reason() {
        return modify_reason;
    }

    public void setModify_reason(String modify_reason) {
        this.modify_reason = modify_reason;
    }
}
