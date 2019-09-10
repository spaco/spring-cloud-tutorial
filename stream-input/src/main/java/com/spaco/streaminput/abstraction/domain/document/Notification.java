package com.spaco.streaminput.abstraction.domain.document;

import com.spaco.streaminput.abstraction.base.BaseDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "notification")
@Data
public class Notification extends BaseDocument {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("content")
    private String content;

    @Field("sourceId")
    private Long sourceId;

    @Field("userId")
    private Long userId;

    @Field("isRead")
    private Boolean isRead;

    @Field("deletedAt")
    private Timestamp deletedAt;

    @Field("source")
    private Source source;

    @Field("type")
    private Type type;

    @Field("sourceType")
    private SourceType sourceType;

    public enum Source {
        sxlq_rental("sxlq_rental"),
        provider("provider"),
        construction("construction");

        private String source;

        Source(String type) {
            this.source = type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

    public enum Type {
        notice("notice"),
        alarm("alarm"),
        review("review");

        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public enum SourceType {
        alarm("alarm"),
        system_notice("system_notice"),
        maintenance("maintenance"),
        apply("apply"),
        machine_entry_record("machine_entry_record"),
        machine_exit_record("machine_exit_record"),
        check_machine_shift("check_machine_shift"),
        check_machine_shift_completed("check_machine_shift_completed"),
        fence_alarm("fence_alarm"),
        fence_alarm_polyline("fence_alarm_polyline"),
        dismantle_gyro("dismantle_gyro"),
        dismantle_magnet("dismantle_magnet"),
        low_power("low_power"),
        oil_too_low("oil_too_low"),
        oil_abnormal("oil_abnormal"),
        refuel("refuel"),
        speeding("speeding"),
        bid_success("bid_success"),
        bid_canceled("bid_canceled"),
        cap_close_timeout("cap_close_timeout"),
        cap_close("cap_close"),
        cap_open("cap_open"),
        check_device_transfer("check_device_transfer"),
        check_device_transfer_completed("check_device_transfer_completed");

        private String sourceType;

        SourceType(String type) {
            this.sourceType = type;
        }

        public String getSourceType() {
            return sourceType;
        }
    }
}
