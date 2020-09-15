package by.itransition.mcollections.dto.columninfo;

import by.itransition.mcollections.entity.ucollection.names.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UcollColumnInfo {
    private List<ColumnInfo> boolFieldNames = new ArrayList<>();
    private List<ColumnInfo> dateFieldNames = new ArrayList<>();
    private List<ColumnInfo> intFieldNames = new ArrayList<>();
    private List<ColumnInfo> stringFieldNames = new ArrayList<>();
    private List<ColumnInfo> textFieldNames = new ArrayList<>();
}
