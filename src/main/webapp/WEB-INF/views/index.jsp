<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <h2><c:out value="${donationsForInstitutions}"/></h2>
            <h3>Oddanych worków</h3>
            <p>Ilość worków z przedmiotami oddanych na rzecz wsparcia wybranych fundacji charytatywnych
            </p>
        </div>

        <div class="stats--item">
            <h2><c:out value="${givenDonations}"/></h2>
            <h3>Przekazanych darów</h3>
            <p>Ilość przekazanych paczek na rzecz współpracujących z nami fundacji charytatywnych
            </p>
        </div>

    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="#" class="btn btn--large">Załóż konto</a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
    </div>
    <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section class="help">
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>

        <ul class="help--slides-items">
            <table>
                <c:forEach items="${institutions}" var="inst" varStatus="count">
                    <c:if test="${count.count % 2 !=0}">
                        <li>
                    </c:if> <!-- CHECK -->
                    <div class="col">
                        <div class="title">${inst.name}</div>
                        <div class="subtitle">${inst.description}</div>
                    </div>
                    <c:if test="${count.count % 2==0}">
                        </li>
                    </c:if>
                </c:forEach>
            </table>
        </ul>


    </div>
</section>
<%@include file="footer.jsp" %>