/**
 * 
 */
package com.elearn.phase1.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.elearn.phase1.domain.Content;
import com.elearn.phase1.repository.ContentRepository;

/**
 * @author kloudone
 *
 */
public class ContentResource {
	
    private final Logger log = LoggerFactory.getLogger(ContentResource.class);

    private static final String ENTITY_NAME = "helpCourse";

    private final ContentRepository contentRepository;

    public ContentResource(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

   /**
    * 
    * POST  /contents : Create a new content.
    * 
    * @param helpCourse
    * @return
    * @throws URISyntaxException
    */
    @PostMapping("/contents")
    public ResponseEntity<Content> createHelpCourse(@Valid @RequestBody Content content) throws URISyntaxException {
        log.debug("REST request to save content : {}", content);
        if (content.getId() != null) {
        	log.debug("A new helpCourse cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Content result = contentRepository.save(content);
        return ResponseEntity.created(new URI("/api/help-courses/" + result.getId()))
            .body(result);
    }

    /**
     * 
     * PUT  /contents : Update existing content.
     * 
     * @param helpCourse
     * @return
     * @throws URISyntaxException
     */

    @PutMapping("/contents")
    public ResponseEntity<Content> updateHelpCourse(@Valid @RequestBody Content content) throws URISyntaxException {
        log.debug("REST request to update HelpCourse : {}", content);
        if (content.getId() == null) {
        	log.debug("Invalid id", ENTITY_NAME, "idnull");
        }
        Content result = contentRepository.save(content);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /contents : get all the contents.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of helpCourses in body
     */
    @GetMapping("/contents")
    public ResponseEntity<List<Content>> getAllHelpCourses(Pageable pageable) {
        log.debug("REST request to get a page of HelpCourses");
        Page<Content> page = contentRepository.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    /**
     * GET  /contents/:id : get the "id" contents.
     *
     * @param id the id of the contents to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the contents, or with status 404 (Not Found)
     */
    @GetMapping("/contents/{id}")
    public ResponseEntity<Content> getHelpCourse(@PathVariable Long id) {
        log.debug("REST request to get HelpCourse : {}", id);
        Optional<Content> content = contentRepository.findById(id);
        return ResponseEntity.ok()
                .body(content.get());
    }

    /**
     * DELETE  /contents/:id : delete the "id" contents.
     *
     * @param id the id of the contents to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/contents/{id}")
    public ResponseEntity<Void> deleteHelpCourse(@PathVariable Long id) {
        log.debug("REST request to delete contents : {}", id);
        contentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
