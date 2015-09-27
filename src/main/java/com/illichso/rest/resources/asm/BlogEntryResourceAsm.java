package com.illichso.rest.resources.asm;

import com.illichso.core.entities.BlogEntry;
import com.illichso.rest.mvc.BlogEntryController;
import com.illichso.rest.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource resource = new BlogEntryResource();
        resource.setTitle(blogEntry.getTitle());
        Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        resource.add(link.withSelfRel());
        return resource;
    }
}
