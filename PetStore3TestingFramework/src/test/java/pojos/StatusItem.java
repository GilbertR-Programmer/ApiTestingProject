package pojos;

import java.util.List;

public record StatusItem(
	List<String> photoUrls,
	String name,
	int id,
	Category category,
	List<TagsItem> tags,
	String status
) {
}