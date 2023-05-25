function toggleFavorite() {
	if (document.getElementById("allBooks").style.display == 'none') {
		document.getElementById("favoriteToggleButton").innerHTML = "Favorite Books"
		document.getElementById("update").innerHTML = "Update Favorites"
		document.getElementById("favoriteBooks").style.display = "none";
		document.getElementById("allBooks").style.display = "block";
	}
	else {
		document.getElementById("favoriteToggleButton").innerHTML = "All Books"
		document.getElementById("update").innerHTML = "Remove Favorites"
		document.getElementById("allBooks").style.display = "none";
		document.getElementById("favoriteBooks").style.display = "block";
	}
}


function updateSelection() {
	if (document.getElementById("update").innerHTML == 'Update Favorites') {
		let favoriteBookIds = [];
		let elements = document.getElementsByClassName("favoriteSelection");
		elements = Array.from(elements);

		elements.forEach(element => {
			if (element.checked) {
				favoriteBookIds.push(element.value)
			}
		});

		fetch("/favorite", {
			method: "POST",
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(favoriteBookIds)
		}).then((response) => response.json)
			.then((json) => console.log(json))
		setTimeout(function() {
			location.reload();
		}, 300);
		
	}
	else {
		let bookIdsToRemoveFavorite = [];
		let elements = document.getElementsByClassName("removeFavoriteSelection");
		elements = Array.from(elements);

		elements.forEach(element => {
			if (element.checked) {
				bookIdsToRemoveFavorite.push(element.value)
			}
		});

		fetch("/favorite", {
			method: "DELETE",
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(bookIdsToRemoveFavorite)
		}).then((response) => response.json)
			.then((json) => console.log(json))

		setTimeout(function() {
			location.reload();
		}, 300);
		
	}

}