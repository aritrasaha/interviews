var Slideshow = function (element, configuration) {
    var slideshow = this;

    slideshow.element = element;
    slideshow.configuration = JSON.parse(configuration);

    var currentIndex = slideshow.configuration.images.length > 0 ? 0 : null;

    var setImage = function (index) {
        slideshow.imageElement.setAttribute("src", slideshow.configuration.images[index].path);
        slideshow.captionElement.innerHTML = slideshow.configuration.images[index].caption;
    };

    var goPrev = function () {
        currentIndex--;
        setImage(currentIndex);
        slideshow.next.disabled = false;
        slideshow.prev.disabled = currentIndex <= 0;
    };

    var goNext = function () {
        currentIndex++;
        setImage(currentIndex);
        slideshow.prev.disabled = false;
        slideshow.next.disabled = currentIndex >= slideshow.configuration.images.length - 1;
    };

    var createTitleElement = function () {
        var titleElement = document.createElement("h3");
        titleElement.innerHTML = slideshow.configuration.title;
        titleElement.classList.add("title");

        slideshow.titleElement = titleElement;
        slideshow.element.appendChild(slideshow.titleElement);
    };

    var createImageElement = function () {
        var imageElement = document.createElement("img");

        slideshow.imageElement = imageElement;
        slideshow.element.appendChild(slideshow.imageElement);
    };

    var createCaptionElement = function () {
        var captionElement = document.createElement("h4");
        captionElement.classList.add("caption");

        slideshow.captionElement = captionElement;
        slideshow.element.appendChild(slideshow.captionElement);
    };

    var createToolbar = function () {
        var toolbar = document.createElement("div");
        toolbar.classList.add("toolbar");

        var prev = document.createElement("button");
        prev.innerHTML = "Previous";
        prev.style.float = "left";
        prev.disabled = true;
        prev.addEventListener("click", goPrev);
        toolbar.appendChild(prev);

        var next = document.createElement("button");
        next.innerHTML = "Next";
        next.style.float = "right";
        next.disabled = currentIndex == null || currentIndex >= slideshow.configuration.images.length - 1;
        next.addEventListener("click", goNext);
        toolbar.appendChild(next);

        var clear = document.createElement("div");
        clear.classList.add("clearfix");
        toolbar.appendChild(clear);

        slideshow.prev = prev;
        slideshow.next = next;
        slideshow.toolbar = toolbar;
        slideshow.element.appendChild(slideshow.toolbar);
    };

    slideshow.init = function () {
        slideshow.element.innerHTML = "";

        createTitleElement()
        createImageElement();
        createCaptionElement();
        createToolbar();

        setImage(currentIndex);
    };
};
