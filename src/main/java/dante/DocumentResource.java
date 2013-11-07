package dante;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/document")
public class DocumentResource {

	private final Logger logger = LoggerFactory
			.getLogger(DocumentResource.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Document getDocument(@PathVariable("id") String id) {
		logger.debug("Fetching document {}", id);
		Document doc = new Document();
		doc.setId(id);
		doc.setTitle(String.valueOf(Math.random()));
		doc.setDate(new Date());
		return doc;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Document createDocument(@RequestBody Document document) {
		logger.debug("creating new document {}", document.getId());
		document.setId(String.valueOf(System.currentTimeMillis()));
		return document;
	}
}
