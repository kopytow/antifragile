const rating = [${ratings}]

rating.forEach((rating, i) => {
    $(".rating__container").append(`
        <div class="rating__user">
            <div class="rating__user-info">
                <div class="rating__user-position" data-position="${i+1}"></div>
                <div class="rating__user-name">${rating.nickname}</div>
<!--                ${rating.show_icon ? `<img class="rating__user-icon" src="./assets/rating-top.png" alt="rating-top-icon">` : ""}-->
                <div class="rating__user-percent">${rating.percent}%</div>
            </div>
            <div class="rating__user-progressbar-bg">
                <div class="rating__user-progressbar" style="width: ${rating.percent}%;"></div>
            </div>
        </div>
    `);
})