<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login · BO4 Meta Loadouts</title>
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            background-color: #0d0d0d;
            color: #e0e0e0;
            font-family: 'Segoe UI', Arial, sans-serif;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        a { color: inherit; text-decoration: none; }

        /* Header */
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

        /* Form container */
        .auth-container {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 3rem 1rem;
        }

        .auth-box {
            background: #161616;
            border: 1px solid #2a2a2a;
            border-radius: 4px;
            padding: 2.5rem 2rem;
            width: 100%;
            max-width: 420px;
        }

        .auth-title {
            font-size: 1.3rem;
            font-weight: 800;
            text-transform: uppercase;
            letter-spacing: 2px;
            color: #fff;
            margin-bottom: 0.4rem;
        }

        .auth-title span { color: #ff6a00; }

        .auth-subtitle {
            font-size: 0.8rem;
            color: #666;
            margin-bottom: 2rem;
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        label {
            display: block;
            font-size: 0.72rem;
            font-weight: 700;
            letter-spacing: 1.5px;
            text-transform: uppercase;
            color: #888;
            margin-bottom: 0.4rem;
        }

        input {
            width: 100%;
            background: #1c1c1c;
            border: 1px solid #2a2a2a;
            border-radius: 3px;
            padding: 0.65rem 0.85rem;
            color: #e0e0e0;
            font-size: 0.9rem;
            outline: none;
            transition: border-color 0.2s;
        }

        input:focus { border-color: #ff6a00; }

        .btn-submit {
            width: 100%;
            padding: 0.75rem;
            background: #ff6a00;
            border: none;
            border-radius: 3px;
            color: #fff;
            font-size: 0.85rem;
            font-weight: 700;
            letter-spacing: 1px;
            text-transform: uppercase;
            cursor: pointer;
            margin-top: 0.5rem;
            transition: background 0.2s;
        }

        .btn-submit:hover { background: #e05e00; }

        .auth-footer {
            margin-top: 1.5rem;
            text-align: center;
            font-size: 0.8rem;
            color: #666;
        }

        .auth-footer a { color: #ff6a00; }
        .auth-footer a:hover { text-decoration: underline; }

        .alert {
            padding: 0.7rem 0.9rem;
            border-radius: 3px;
            font-size: 0.82rem;
            margin-bottom: 1.25rem;
        }

        .alert-error {
            background: #2a0000;
            border-left: 3px solid #c00;
            color: #f88;
        }

        .alert-success {
            background: #002a00;
            border-left: 3px solid #0a0;
            color: #8f8;
        }

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

<header>
    <div class="logo">BO4 Meta Loadouts</div>
    <nav>
        <a href="${pageContext.request.contextPath}/index">Home</a>
        <a href="#">Browse</a>
        <a href="${pageContext.request.contextPath}/register">Register</a>
    </nav>
</header>

<div class="auth-container">
    <div class="auth-box">
        <div class="auth-title">Log <span>In</span></div>
        <div class="auth-subtitle">Welcome back. Sign in to your account.</div>

        <c:if test="${not empty error}">
            <div class="alert alert-error">${error}</div>
        </c:if>

        <c:if test="${not empty success}">
            <div class="alert alert-success">${success}</div>
        </c:if>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="your@email.com" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required>
            </div>
            <button type="submit" class="btn-submit">Sign In</button>
        </form>

        <div class="auth-footer">
            Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a>
        </div>
    </div>
</div>

<footer>
    Fan-made project · Not affiliated with <span>Treyarch</span> or <span>Activision</span>
</footer>

</body>
</html>
