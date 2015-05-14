var initSlideshow = function (element, configuration) {
    var slideshow = new Slideshow(element, configuration);
    slideshow.init();
};

var getLoader = function () {
    var loader = document.createElement("img");
    loader.setAttribute('src', 'loading.gif');
    loader.setAttribute('height', '100%');
    loader.setAttribute('width', '100%');
    return loader;
};

var loadData = function (element, configPath) {
    var xmlhttp;
    
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        switch (xmlhttp.readyState) {
            case 1:
                element.appendChild(getLoader());
                break;
            case 4:
                if (xmlhttp.status == 200) {
                    var configuration = xmlhttp.responseText;
                    initSlideshow(element, configuration);
                } else {
                    element.innerHTML = "";
                }
        }
    }

    xmlhttp.open("GET", configPath, true);
    xmlhttp.send();
};

var init = function () {
    loadData(document.getElementById("cats"), "configCat.json");
    loadData(document.getElementById("tigers"), "configTiger.json");
};
