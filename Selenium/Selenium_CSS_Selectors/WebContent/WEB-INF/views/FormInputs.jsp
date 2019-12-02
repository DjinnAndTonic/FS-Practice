<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Inputs</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" ></script>
</head>
<body>
 	<header>
	 	<h1 id="pageTitle">Selenium Input Demonstration Page</h1>
		<form action="javascript:;" onSubmit="return submitSearch(this)" method="post">
			<input type="text" name="searchInput" placeholder="Search" />
			<input type="submit" value="Search" />
		</form>
	</header>
	<fieldset>
		<legend>Course Form</legend>
		<form action="javascript:;" onSubmit="return showSelections(this);" method="post">
			<div id="selectInput">
				<label>Select a course: </label>
				<select name="selectCourse">
					<option value="Application Support Management">ASM</option>
					<option value="Data Engineering">DE</option>
					<option value="Quality Engineering & Assurance">QEA</option>
				</select>
			</div>
			<div id="radioInput">
				<label>Select a Location: </label>
				<input type="radio" name="courseLocation" value="Dallas" />Dallas
				<input type="radio" name="courseLocation" value="Irving" />Irving
			</div>
			<div id="checkboxInput">
				<label>Relocation Preferences (check all that apply): </label>
				<input type="checkbox" name="relocationPreference" value="Aspen">Aspen
				<input type="checkbox" name="relocationPreference" value="Honolulu">Honolulu
				<input type="checkbox" name="relocationPreference" value="Lake Tahoe">Lake Tahoe
				<input type="checkbox" name="relocationPreference" value="Miami">Miami
			</div>
			<div id="dateAvailableInput">
				<label>Date Available: </label>
				<input type="date" name="dateAvailable" />
			</div>
			<div id="fileInput">
				Select a file: <input type="file" name="fileUpload" />
			</div>
			<input type="submit" value="Submit" />
		</form>
	</fieldset>
	<fieldset id="resultsFieldset" style="display: none;"></fieldset>
	<%@ include file="Footer.html" %>
	<script>
		function submitSearch(queryData) {
			var searchResultElement;
			
			var catalog = createCatalog();
			var queryString = queryData['searchInput'].value
			var mainHeader = document.querySelector("body > header");
			var searchMessage = document.createElement("p");
			
			if (catalog.includes(queryString)) {
				searchMessage.innerHTML = "The course " + queryString + " was found in the catalog.";
				mainHeader.appendChild(searchMessage);
			} else {
				searchMessage.setAttribute("style", "color: red;");
				searchMessage.innerHTML = "There was no match for your query.";
				mainHeader.appendChild(searchMessage);
			}
		}

		function showSelections(formData) {
		    var resultsFieldset = document.getElementById("resultsFieldset");
		    
 		    while (r = resultsFieldset.firstChild) {
 		    	resultsFieldset.removeChild(r);
		    }
 		    
 		    var fsLegend = document.createElement("legend");
 		    fsLegend.innerHTML = "Course Preferences";
 		    resultsFieldset.appendChild(fsLegend);

		    var pTagCourse = document.createElement("p");
		    pTagCourse.innerHTML = "Course: " + formData["selectCourse"].value;
		    resultsFieldset.appendChild(pTagCourse);
		    
		    var pTagLocation = document.createElement("p");
		    pTagLocation.innerHTML = "Location: " + formData["courseLocation"].value;
		    resultsFieldset.appendChild(pTagLocation);
		    
		    var relocHeader = document.createElement("p");
		    relocHeader.innerHTML = "Relocation Preferences:";
		    resultsFieldset.appendChild(relocHeader);
			var prefs = formData["relocationPreference"];
			for (var i = 0; i < prefs.length; i++) {
				if (prefs[i].checked == true) {
					var pTagPref = document.createElement("p");
					pTagPref.innerHTML = prefs[i].value;
					pTagPref.setAttribute("style", "margin-left: 25px;")
					resultsFieldset.appendChild(pTagPref);
				}
			}
			
		    var pTagAvailability = document.createElement("p");
		    pTagAvailability.innerHTML = "Availability: " + formData["dateAvailable"].value;
		    resultsFieldset.appendChild(pTagAvailability);
		    
		    var pTagFileName = document.createElement("p");
		    pTagFileName.innerHTML = "FileName: " + formData["fileUpload"].value;
		    resultsFieldset.appendChild(pTagFileName);
			
		    resultsFieldset.setAttribute("style", "display: block;");
		}
		
		function createCatalog() {
			var courses = [];
			/* The getElementsByName() function returns an array of elements with the
			 * specified name. In this case, it returns an array with only one <select> 
			 * element, so the index [0] is specified which returns a list of <option> 
			 * elements that are children of the <select> element. */
			var catalogList = document.getElementsByName("selectCourse")[0];
			/* The jQuery .each() function is used to iterate over the options list and 
			 * add course names to the catalog. */
			$.each(catalogList, function(i,s) {
				courses.push(s.innerHTML);
				courses.push(s.getAttribute("value"));
			});
			return courses;
		}
	</script>
</body>
</html>