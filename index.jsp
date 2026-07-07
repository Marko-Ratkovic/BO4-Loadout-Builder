<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BO4 Loadouts</title>
    <style>
        /* ── Reset & base ──────────────────────────────────────────────────── */
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            background-color: #0d0d0d;
            color: #e0e0e0;
            font-family: 'Segoe UI', Arial, sans-serif;
            min-height: 100vh;
        }

        a { color: inherit; text-decoration: none; }

        /* ── Header ────────────────────────────────────────────────────────── */
        header {
            background: #111;
            border-bottom: 2px solid #ff6a00;
            padding: 0 2rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
            height: 60px;
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .logo {
            font-size: 1.4rem;
            font-weight: 800;
            letter-spacing: 1px;
            color: #ff6a00;
            text-transform: uppercase;
        }

        nav a {
            margin-left: 1.5rem;
            font-size: 0.85rem;
            font-weight: 600;
            letter-spacing: 0.5px;
            text-transform: uppercase;
            color: #aaa;
            transition: color 0.2s;
        }
        nav a:hover { color: #ff6a00; }

        /* ── Hero banner ───────────────────────────────────────────────────── */
        .hero {
            background: linear-gradient(135deg, #1a0a00 0%, #0d0d0d 60%);
            border-bottom: 1px solid #2a2a2a;
            padding: 3.5rem 2rem 2.5rem;
            text-align: center;
        }

        .hero h1 {
            font-size: 2.4rem;
            font-weight: 900;
            letter-spacing: 2px;
            text-transform: uppercase;
            color: #fff;
        }

        .hero h1 span { color: #ff6a00; }

        .hero p {
            margin-top: 0.75rem;
            color: #888;
            font-size: 1rem;
        }

        /* ── Section titles ────────────────────────────────────────────────── */
        .section-title {
            display: flex;
            align-items: center;
            gap: 0.75rem;
            font-size: 0.75rem;
            font-weight: 700;
            letter-spacing: 2px;
            text-transform: uppercase;
            color: #ff6a00;
            margin: 2.5rem 2rem 1rem;
        }

        .section-title::after {
            content: '';
            flex: 1;
            height: 1px;
            background: #2a2a2a;
        }

        /* ── Error banner ──────────────────────────────────────────────────── */
        .db-error {
            margin: 1rem 2rem;
            padding: 0.75rem 1rem;
            background: #3a0000;
            border-left: 3px solid #c00;
            font-size: 0.85rem;
            color: #f88;
        }

        /* ── Loadout grid ──────────────────────────────────────────────────── */
        .loadout-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(340px, 1fr));
            gap: 1.25rem;
            padding: 0 2rem 3rem;
        }

        /* ── Loadout card ──────────────────────────────────────────────────── */
        .card {
            background: #161616;
            border: 1px solid #2a2a2a;
            border-radius: 4px;
            overflow: hidden;
            transition: border-color 0.2s, transform 0.2s;
            cursor: pointer;
        }

        .card:hover {
            border-color: #ff6a00;
            transform: translateY(-2px);
        }

        /* Card header row */
        .card-header {
            display: flex;
            align-items: center;
            gap: 0.75rem;
            padding: 0.85rem 1rem;
            background: #1c1c1c;
            border-bottom: 1px solid #2a2a2a;
        }

        .weapon-img {
            width: 52px;
            height: 36px;
            object-fit: contain;
            flex-shrink: 0;
            filter: drop-shadow(0 0 4px rgba(255,106,0,0.3));
        }

        .weapon-img.missing {
            background: #222;
            border: 1px dashed #444;
            border-radius: 2px;
        }

        .card-titles { flex: 1; min-width: 0; }

        .card-name {
            font-size: 0.95rem;
            font-weight: 700;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            color: #fff;
        }

        .card-weapon-label {
            font-size: 0.7rem;
            color: #888;
            margin-top: 2px;
        }

        .card-weapon-label span { color: #ff6a00; font-weight: 600; }

        /* Pick 10 dots */
        .pick10 {
            display: flex;
            gap: 3px;
            align-items: center;
            flex-shrink: 0;
        }

        .pick10 .dot {
            width: 7px;
            height: 7px;
            border-radius: 50%;
            background: #ff6a00;
        }

        .pick10 .dot.empty { background: #333; }

        /* Collapsible details */
        .card-details {
            display: none;
            padding: 0.85rem 1rem;
            border-top: 1px solid #222;
            animation: fadeIn 0.15s ease;
        }

        .card.open .card-details { display: block; }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-4px); }
            to   { opacity: 1; transform: translateY(0); }
        }

        /* Detail sections inside card */
        .detail-section {
            margin-bottom: 0.85rem;
        }

        .detail-section:last-child { margin-bottom: 0; }

        .detail-label {
            font-size: 0.65rem;
            font-weight: 700;
            letter-spacing: 1.5px;
            text-transform: uppercase;
            color: #ff6a00;
            margin-bottom: 0.4rem;
        }

        .icon-row {
            display: flex;
            flex-wrap: wrap;
            gap: 6px;
            align-items: center;
        }

        .icon-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 3px;
            width: 52px;
        }

        .icon-item img {
            width: 40px;
            height: 28px;
            object-fit: contain;
            filter: brightness(0.9);
        }

        .icon-item span {
            font-size: 0.6rem;
            color: #888;
            text-align: center;
            line-height: 1.2;
            word-break: break-word;
        }

        /* Secondary weapon row in details */
        .secondary-row {
            display: flex;
            align-items: center;
            gap: 0.6rem;
            margin-bottom: 0.5rem;
        }

        .secondary-row img.weapon-img-sm {
            width: 44px;
            height: 30px;
            object-fit: contain;
        }

        .secondary-row .sw-name {
            font-size: 0.8rem;
            font-weight: 600;
            color: #ccc;
        }

        .secondary-row .sw-cat {
            font-size: 0.65rem;
            color: #666;
        }

        /* Description text */
        .card-description {
            font-size: 0.78rem;
            color: #777;
            line-height: 1.5;
            margin-bottom: 0.75rem;
            font-style: italic;
        }

        /* Toggle arrow */
        .toggle-arrow {
            float: right;
            font-size: 0.8rem;
            color: #555;
            transition: transform 0.2s;
            line-height: 1;
        }

        .card.open .toggle-arrow { transform: rotate(180deg); }

        /* ── Footer ────────────────────────────────────────────────────────── */
        footer {
            border-top: 1px solid #1e1e1e;
            padding: 1.5rem 2rem;
            text-align: center;
            font-size: 0.72rem;
            color: #444;
        }

        footer span { color: #ff6a00; }
    </style>
</head>
<body>

<!-- ── Header ──────────────────────────────────────────────────────────────── -->
<header>
    <div class="logo">BO4 Loadouts</div>
    <nav>
        <a href="${pageContext.request.contextPath}/index">Home</a>
        <a href="#">Browse</a>
        <a href="#">Weapons</a>
    </nav>
</header>

<!-- ── Hero ────────────────────────────────────────────────────────────────── -->
<div class="hero">
    <h1>Black Ops 4 <span>Loadout Builder</span></h1>
    <p>Fan-made meta loadouts for every weapon in the game.</p>
</div>

<!-- ── DB error (only shown if something went wrong) ───────────────────────── -->
<c:if test="${not empty dbError}">
    <div class="db-error">⚠ ${dbError}</div>
</c:if>

<!-- ── Featured loadouts ───────────────────────────────────────────────────── -->
<div class="section-title">⭐ Featured Loadouts</div>

<c:choose>
    <c:when test="${empty featuredLoadouts}">
        <p style="margin:1rem 2rem; color:#555; font-size:0.85rem;">No featured loadouts found.</p>
    </c:when>
    <c:otherwise>
        <div class="loadout-grid">
            <c:forEach var="lo" items="${featuredLoadouts}">

                <%-- Build pick-10 dots (10 total, filled up to pick_10_total) --%>
                <c:set var="pickTotal" value="${lo.pickTotal}" />

                <div class="card" onclick="this.classList.toggle('open')">

                    <!-- Card header: weapon image + name + pick-10 -->
                    <div class="card-header">

                        <!-- Primary weapon image -->
                        <c:choose>
                            <c:when test="${not empty lo.primaryWeaponImage}">
                                <img class="weapon-img"
                                     src="${pageContext.request.contextPath}/${lo.primaryWeaponImage}"
                                     alt="${lo.primaryWeaponName}">
                            </c:when>
                            <c:when test="${not empty lo.secondaryWeaponImage}">
                                <img class="weapon-img"
                                     src="${pageContext.request.contextPath}/${lo.secondaryWeaponImage}"
                                     alt="${lo.secondaryWeaponName}"
                                     onerror="this.style.display='none'">
                            </c:when>
                        </c:choose>

                        <div class="card-titles">
                            <div class="card-name">
                                ${lo.title}
                                <span class="toggle-arrow">▼</span>
                            </div>
                            <div class="card-weapon-label">
                                <c:choose>
                                    <c:when test="${not empty lo.primaryWeaponName}">
                                        <span>${lo.primaryWeaponName}</span>
                                        <c:if test="${not empty lo.primaryWeaponCategory}">
                                            · ${lo.primaryWeaponCategory}
                                        </c:if>
                                    </c:when>
                                    <c:when test="${not empty lo.secondaryWeaponName}">
                                        <span>${lo.secondaryWeaponName}</span>
                                        <c:if test="${not empty lo.secondaryWeaponCategory}">
                                            · ${lo.secondaryWeaponCategory}
                                        </c:if>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>

                        <!-- Pick-10 dots -->
                        <div class="pick10">
                            <c:forEach begin="1" end="10" var="dot">
                                <c:choose>
                                    <c:when test="${dot <= pickTotal}">
                                        <div class="dot"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="dot empty"></div>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>

                    <!-- Expandable details -->
                    <div class="card-details">

                        <!-- Description -->
                        <c:if test="${not empty lo.description}">
                            <div class="card-description">${lo.description}</div>
                        </c:if>

                        <!-- Primary weapon section -->
                        <c:if test="${not empty lo.primaryWeaponName}">
                            <div class="detail-section">
                                <div class="detail-label">Primary</div>
                                <div class="icon-row">

                                    <!-- Optic -->
                                    <c:if test="${not empty lo.primaryOpticName}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryOpticImage}"
                                                 alt="${lo.primaryOpticName}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryOpticName}</span>
                                        </div>
                                    </c:if>

                                    <!-- Attachments -->
                                    <c:if test="${not empty lo.primaryAt1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryAt1Image}"
                                                 alt="${lo.primaryAt1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryAt1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.primaryAt2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryAt2Image}"
                                                 alt="${lo.primaryAt2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryAt2Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.primaryAt3Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryAt3Image}"
                                                 alt="${lo.primaryAt3Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryAt3Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.primaryAt4Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryAt4Image}"
                                                 alt="${lo.primaryAt4Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryAt4Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.primaryAt5Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.primaryAt5Image}"
                                                 alt="${lo.primaryAt5Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.primaryAt5Name}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>

                        <!-- Secondary weapon section -->
                        <c:if test="${not empty lo.secondaryWeaponName}">
                            <div class="detail-section">
                                <div class="detail-label">Secondary</div>
                                <div class="secondary-row">
                                    <c:if test="${not empty lo.secondaryWeaponImage}">
                                        <img class="weapon-img-sm"
                                             src="${pageContext.request.contextPath}/${lo.secondaryWeaponImage}"
                                             alt="${lo.secondaryWeaponName}"
                                             onerror="this.style.display='none'">
                                    </c:if>
                                    <div>
                                        <div class="sw-name">${lo.secondaryWeaponName}</div>
                                        <div class="sw-cat">${lo.secondaryWeaponCategory}</div>
                                    </div>
                                </div>
                                <div class="icon-row">
                                    <c:if test="${not empty lo.secondaryOpticName}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryOpticImage}"
                                                 alt="${lo.secondaryOpticName}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryOpticName}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.secondaryAt1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryAt1Image}"
                                                 alt="${lo.secondaryAt1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryAt1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.secondaryAt2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryAt2Image}"
                                                 alt="${lo.secondaryAt2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryAt2Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.secondaryAt3Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryAt3Image}"
                                                 alt="${lo.secondaryAt3Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryAt3Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.secondaryAt4Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryAt4Image}"
                                                 alt="${lo.secondaryAt4Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryAt4Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.secondaryAt5Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.secondaryAt5Image}"
                                                 alt="${lo.secondaryAt5Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.secondaryAt5Name}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>

                        <!-- Perks -->
                        <c:if test="${not empty lo.perk1Slot1Name or not empty lo.perk2Slot1Name or not empty lo.perk3Slot1Name}">
                            <div class="detail-section">
                                <div class="detail-label">Perks</div>
                                <div class="icon-row">
                                    <c:if test="${not empty lo.perk1Slot1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk1Slot1Image}"
                                                 alt="${lo.perk1Slot1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk1Slot1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.perk1Slot2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk1Slot2Image}"
                                                 alt="${lo.perk1Slot2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk1Slot2Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.perk2Slot1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk2Slot1Image}"
                                                 alt="${lo.perk2Slot1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk2Slot1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.perk2Slot2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk2Slot2Image}"
                                                 alt="${lo.perk2Slot2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk2Slot2Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.perk3Slot1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk3Slot1Image}"
                                                 alt="${lo.perk3Slot1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk3Slot1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.perk3Slot2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.perk3Slot2Image}"
                                                 alt="${lo.perk3Slot2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.perk3Slot2Name}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>

                        <!-- Gear / Equipment / Wildcards -->
                        <c:if test="${not empty lo.gearName or not empty lo.equipmentName or not empty lo.wildcard1Name}">
                            <div class="detail-section">
                                <div class="detail-label">Gear &amp; Equipment</div>
                                <div class="icon-row">
                                    <c:if test="${not empty lo.gearName}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.gearImage}"
                                                 alt="${lo.gearName}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.gearName}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.equipmentName}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.equipmentImage}"
                                                 alt="${lo.equipmentName}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.equipmentName}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.wildcard1Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.wildcard1Image}"
                                                 alt="${lo.wildcard1Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.wildcard1Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.wildcard2Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.wildcard2Image}"
                                                 alt="${lo.wildcard2Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.wildcard2Name}</span>
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty lo.wildcard3Name}">
                                        <div class="icon-item">
                                            <img src="${pageContext.request.contextPath}/${lo.wildcard3Image}"
                                                 alt="${lo.wildcard3Name}"
                                                 onerror="this.style.opacity='0.3'">
                                            <span>${lo.wildcard3Name}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>

                    </div><!-- /card-details -->
                </div><!-- /card -->

            </c:forEach>
        </div><!-- /loadout-grid -->
    </c:otherwise>
</c:choose>

<!-- ── Footer ──────────────────────────────────────────────────────────────── -->
<footer>
    Fan-made project · Not affiliated with <span>Treyarch</span> or <span>Activision</span>
</footer>

</body>
</html>
